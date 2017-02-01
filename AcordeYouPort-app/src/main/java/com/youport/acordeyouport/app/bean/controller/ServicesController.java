package com.youport.acordeyouport.app.bean.controller;

import com.youport.acordeyouport.app.bean.session.ConfigurationMasterParameter;
import com.youport.acordeyouport.app.entity.Services;
import com.youport.acordeyouport.app.enums.ConditionType;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@Named(value = "servicesController")
@ViewScoped
public class ServicesController extends AbstractController<Services> {

    private String UPLOAD_DIRECTORY_IMAGE_RELATIVE;
    private static final int BUFFER = 1024;

    private UploadedFile fileImage;

    public ServicesController() {
        // Inform the Abstract parent controller of the concrete Services Entity
        super(Services.class);
    }

    @PostConstruct
    public void init() {
        UPLOAD_DIRECTORY_IMAGE_RELATIVE = configurationMasterParameter.getParameter(ConfigurationMasterParameter.UPLOAD_DIRECTORY_IMAGE_RELATIVE);
        setFileImage(null);
    }

    /**
     * Sets the "items" attribute with a collection of ServicesCompany entities
     * that are retrieved from Services?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for ServicesCompany page
     */
    public String navigateServicesCompanyList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("ServicesCompany_items", this.getSelected().getServicesCompanyList());
        }
        return "/admin/servicesCompany/index";
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

        getSelected().setUrlImage(file.getFileName());
        String fileExtension = file.getFileName().split("\\.")[file.getFileName().split("\\.").length - 1];

        //String generatedFileName = "file" + System.currentTimeMillis();
        File directory = new File(faces.getExternalContext().getRealPath(UPLOAD_DIRECTORY_IMAGE_RELATIVE));

        if (!directory.exists()) {
            directory.mkdir();
        }

        File newFile = new File(faces.getExternalContext().getRealPath(UPLOAD_DIRECTORY_IMAGE_RELATIVE) + File.separator + file.getFileName() + "." + fileExtension);
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
        getSelected().setUrlImage(event.getFile().getFileName());
        RequestContext.getCurrentInstance().update("image");

    }

    /**
     * Remueve el archivo almacenado en atributo controller
     */
    public void removeImage() {
        setFileImage(null);
        getSelected().setUrlImage(null);
        RequestContext.getCurrentInstance().update("image");
    }

    /**
     * Metodo encargado de persistir la informacion del servicio
     *
     * @param condition
     */
    public void saveService(String condition) {
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
