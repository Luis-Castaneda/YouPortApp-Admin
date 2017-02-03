package com.youport.acordeyouport.app.bean.controller;

import com.youport.acordeyouport.app.bean.session.ConfigurationMasterParameter;
import com.youport.acordeyouport.app.entity.MenuOption;
import com.youport.acordeyouport.app.enums.ConditionType;
import com.youport.acordeyouport.app.enums.ImageType;
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

@Named(value = "menuOptionController")
@ViewScoped
public class MenuOptionController extends AbstractController<MenuOption> {

    private String UPLOAD_DIRECTORY_IMAGE_RELATIVE;
    private static final int BUFFER = 1024;

    private UploadedFile fileImageOver;
    private UploadedFile fileImageNormal;

    @Inject
    private ViewController viewController;
    @Inject
    private MenuTypeController menuTypeController;

    public MenuOptionController() {
        // Inform the Abstract parent controller of the concrete MenuOption Entity
        super(MenuOption.class);
    }

    @PostConstruct
    public void init() {
        UPLOAD_DIRECTORY_IMAGE_RELATIVE = configurationMasterParameter.getParameter(ConfigurationMasterParameter.UPLOAD_DIRECTORY_IMAGE_RELATIVE);
        setFileImageNormal(null);
        setFileImageOver(null);
    }

    
    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        viewController.setSelected(null);
        menuTypeController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the View controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareView(ActionEvent event) {
        if (this.getSelected() != null && viewController.getSelected() == null) {
            viewController.setSelected(this.getSelected().getView());
        }
    }

    /**
     * Sets the "selected" attribute of the MenuType controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMenuType(ActionEvent event) {
        if (this.getSelected() != null && menuTypeController.getSelected() == null) {
            menuTypeController.setSelected(this.getSelected().getMenuType());
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
    public void uploadTempImageNormal(FileUploadEvent event) {
        setFileImageNormal(event.getFile());
        getSelected().setUrlImageNormal(event.getFile().getFileName());
        RequestContext.getCurrentInstance().update("imageNormal");

    }

    /**
     * Metodo encargado de guardar el UploadedFile en la instancia del
     * controller
     *
     * @param event
     */
    public void uploadTempImageOver(FileUploadEvent event) {
        setFileImageOver(event.getFile());
        getSelected().setUrlImageOver(event.getFile().getFileName());
        RequestContext.getCurrentInstance().update("imageOver");

    }

    /**
     * Remueve el archivo almacenado en atributo controller
     */
    public void removeImage(String typeImage) {
        if (typeImage.equals(ImageType.NORMAL.getTypeImage())) {
            setFileImageNormal(null);
            getSelected().setUrlImageNormal(null);
            RequestContext.getCurrentInstance().update("imageNormal");
        } else {
            setFileImageOver(null);
            getSelected().setUrlImageOver(null);
            RequestContext.getCurrentInstance().update("imageOver");

        }
    }

    /**
     * Metodo encargado de persistir la informacion del servicio
     *
     * @param condition
     */
    public void saveMenuOption(String condition) {
        if (super.getSelected() != null) {
            if (getFileImageNormal() != null) {
                upload(getFileImageNormal());
                getSelected().setUrlImageNormal(getFileImageNormal().getFileName());
            }
            if (getFileImageOver() != null) {
                upload(getFileImageOver());
                getSelected().setUrlImageOver(getFileImageOver().getFileName());
            }
            if (condition != null && ConditionType.NEW.getNameCondition().equals(condition)) {
                saveNew(null);
            } else {
                save(null);
            }
        }
        setFileImageNormal(null);
        setFileImageOver(null);
    }

    public UploadedFile getFileImageOver() {
        return fileImageOver;
    }

    public void setFileImageOver(UploadedFile fileImageOver) {
        this.fileImageOver = fileImageOver;
    }

    public UploadedFile getFileImageNormal() {
        return fileImageNormal;
    }

    public void setFileImageNormal(UploadedFile fileImageNormal) {
        this.fileImageNormal = fileImageNormal;
    }

}
