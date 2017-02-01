package com.youport.acordeyouport.app.bean.controller;

import com.youport.acordeyouport.app.bean.session.ConfigurationMasterParameter;
import com.youport.acordeyouport.app.entity.Company;
import com.youport.acordeyouport.app.entity.Provincias;
import com.youport.acordeyouport.app.enums.ConditionType;
import com.youport.acordeyouport.app.facade.ProvinciasFacade;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@Named(value = "companyController")
@ViewScoped
public class CompanyController extends AbstractController<Company> {

    private String UPLOAD_DIRECTORY_IMAGE_RELATIVE;
    private static final int BUFFER = 1024;

    private UploadedFile fileImage;

    @Inject
    private ThemeController idThemeController;
    @EJB
    private ProvinciasFacade provinciasFacade;
    private List<Provincias> provinciasList;

    public CompanyController() {
        super(Company.class);

        // Inform the Abstract parent controller of the concrete Company Entity
        provinciasFacade = new ProvinciasFacade();

    }

    @PostConstruct
    public void init() {
        UPLOAD_DIRECTORY_IMAGE_RELATIVE = configurationMasterParameter.getParameter(ConfigurationMasterParameter.UPLOAD_DIRECTORY_IMAGE_RELATIVE);
        provinciasList = provinciasFacade.findAll();
        setFileImage(null);

        System.out.println("provinciasList: " + provinciasList);

    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idThemeController.setSelected(null);
    }

    /**
     * Sets the "items" attribute with a collection of ServicesCompany entities
     * that are retrieved from Company?cap_first and returns the navigation
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
     * Sets the "items" attribute with a collection of Contact entities that are
     * retrieved from Company?cap_first and returns the navigation outcome.
     *
     * @return navigation outcome for Contact page
     */
    public String navigateContactList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("Contact_items", this.getSelected().getContactList());
        }
        return "/admin/contact/index";
    }

    /**
     * Sets the "selected" attribute of the Theme controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdTheme(ActionEvent event) {
        if (this.getSelected() != null && idThemeController.getSelected() == null) {
            idThemeController.setSelected(this.getSelected().getIdTheme());
        }
    }

    /**
     * Sets the "items" attribute with a collection of SectionCompany entities
     * that are retrieved from Company?cap_first and returns the navigation
     * outcome.
     *
     * @return navigation outcome for SectionCompany page
     */
    public String navigateSectionCompanyList() {
        if (this.getSelected() != null) {
            FacesContext.getCurrentInstance().getExternalContext().getRequestMap().put("SectionCompany_items", this.getSelected().getSectionCompanyList());
        }
        return "/admin/sectionCompany/index";
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
    public void saveCompany(String condition) {
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

    /**
     * ********************* GETTER & SETTER
     * ************************************
     */
    /**
     * @return the provinciasList
     */
    public List<Provincias> getProvinciasList() {
        return provinciasList;
    }

    /**
     * @param provinciasList the provinciasList to set
     */
    public void setProvinciasList(List<Provincias> provinciasList) {
        this.provinciasList = provinciasList;
    }

    public UploadedFile getFileImage() {
        return fileImage;
    }

    public void setFileImage(UploadedFile fileImage) {
        this.fileImage = fileImage;
    }

}
