package com.youport.acordeyouport.app.bean.controller;

import com.youport.acordeyouport.app.bean.session.ConfigurationMasterParameter;
import com.youport.acordeyouport.app.entity.Promotion;
import com.youport.acordeyouport.app.enums.ConditionType;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@Named(value = "promotionController")
@ViewScoped
public class PromotionController extends AbstractController<Promotion> {

    private String UPLOAD_DIRECTORY_IMAGE_RELATIVE;
    private static final int BUFFER = 1024;

    private UploadedFile fileImage;

    @Inject
    private TypePromotionController idTypePromotionController;
    @Inject
    private CompanyController idCompanyController;

    public PromotionController() {
        // Inform the Abstract parent controller of the concrete Promotion Entity
        super(Promotion.class);
    }

    @PostConstruct
    public void init() {
        UPLOAD_DIRECTORY_IMAGE_RELATIVE = configurationMasterParameter.getParameter(ConfigurationMasterParameter.UPLOAD_DIRECTORY_IMAGE_RELATIVE);
        setFileImage(null);

    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idTypePromotionController.setSelected(null);
        idCompanyController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the TypePromotion controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTypePromotion(ActionEvent event) {
        if (this.getSelected() != null && idTypePromotionController.getSelected() == null) {
            idTypePromotionController.setSelected(this.getSelected().getIdTypePromotion());
        }
    }

    /**
     * Sets the "selected" attribute of the Company controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdCompany(ActionEvent event) {
        if (this.getSelected() != null && idCompanyController.getSelected() == null) {
            idCompanyController.setSelected(this.getSelected().getIdCompany());
        }
    }

    /**
     * Medodo encargado de crear el archivo JPG en el contexto de la
     * aplicacion.... desde esta ubicacion podran ser accedidos via web atraves
     * de la url absoluta
     *
     * @param event
     */
    public void upload(UploadedFile file) {
        FacesContext faces = FacesContext.getCurrentInstance();

        getSelected().setUrlImagel(file.getFileName());
        String fileExtension = file.getFileName().split("\\.")[file.getFileName().split("\\.").length - 1];

        //String generatedFileName = "file" + System.currentTimeMillis();
        File directory = new File(faces.getExternalContext().getRealPath(UPLOAD_DIRECTORY_IMAGE_RELATIVE));

        if (!directory.exists()) {
            directory.mkdir();
        }

        File newFile = new File(faces.getExternalContext().getRealPath(UPLOAD_DIRECTORY_IMAGE_RELATIVE) + File.separator + file.getFileName());
        try {
            if (newFile.createNewFile()) {

                FileOutputStream output = new FileOutputStream(newFile);

                byte[] buffer = new byte[BUFFER];

                int bulk;

                InputStream input = file.getInputstream();

                while (true) {
                    bulk = input.read(buffer);

                    if (bulk < 0) {
                        break;
                    }

                    output.write(buffer, 0, bulk);
                    output.flush();
                }

                output.close();
                input.close();

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    /**
     * Metodo encargado de guardar el UploadedFile en la instancia del
     * controller
     *
     * @param event
     */
    public void uploadTemp(FileUploadEvent event) {
        setFileImage(event.getFile());
        getSelected().setUrlImagel(event.getFile().getFileName());
        RequestContext.getCurrentInstance().update("image");

    }

    /**
     * Remueve el archivo almacenado en atributo controller
     */
    public void removeImage() {
        setFileImage(null);
        getSelected().setUrlImagel(null);
        RequestContext.getCurrentInstance().update("image");
    }

    /**
     * Metodo encargado de persistir la informacion del servicio
     *
     * @param condition
     */
    public void savePromotion(String condition) {
        if (super.getSelected() != null) {
            if (getFileImage() != null) {
                upload(getFileImage());
            }
            if (condition != null && ConditionType.NEW.getNameCondition().equals(condition)) {
                saveNew(null);
            } else {
                save(null);
            }
        }
        setFileImage(null);
    }

    public UploadedFile getFileImage() {
        return fileImage;
    }

    public void setFileImage(UploadedFile fileImage) {
        this.fileImage = fileImage;
    }
}
