package com.youport.acordeyouport.app.bean.controller;

import com.youport.acordeyouport.app.bean.session.ConfigurationMasterParameter;
import com.youport.acordeyouport.app.entity.AttachmentFile;
import com.youport.acordeyouport.app.entity.SectionCompany;
import com.youport.acordeyouport.app.enums.ConditionType;
import com.youport.acordeyouport.app.enums.OperationType;
import com.youport.acordeyouport.app.facade.AttachmentFileFacade;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

@Named(value = "sectionCompanyController")
@ManagedBean
@ViewScoped
public class SectionCompanyController extends AbstractController<SectionCompany> {

    @Inject
    private SectionMenuCompanyController idSectionController;

    @Inject
    private CompanyController idCompany;
    @EJB
    private AttachmentFileFacade attachmentFileFacade;

    private String paragraph;

    private List<UploadedFile> uploadImage;
    private List<AttachmentFile> attachmentList;

    public static String UPLOAD_DIRECTORY_IMAGE_RELATIVE;

    protected ResourceBundle bundle = ResourceBundle.getBundle("/YouPortBundle");
    private String operation;
    private String form;

    private StringBuilder imageUrl;

    public SectionCompanyController() {
        // Inform the Abstract parent controller of the concrete SectionCompany Entity
        super(SectionCompany.class);

    }

    @PostConstruct
    public void init() {
        imageUrl = new StringBuilder();
        uploadImage = new ArrayList<>();
        attachmentList = new ArrayList<>();
        UPLOAD_DIRECTORY_IMAGE_RELATIVE = configurationMasterParameter.getParameter(ConfigurationMasterParameter.UPLOAD_DIRECTORY_IMAGE_RELATIVE);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        idSectionController.setSelected(null);
        idCompany.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the SectionMenuCompany controller in
     * order to display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdSection(ActionEvent event) {
        if (this.getSelected() != null && idSectionController.getSelected() == null) {
            idSectionController.setSelected(this.getSelected().getIdSection());
        }
    }

    /**
     * Sets the "selected" attribute of the idCompany controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareIdCompany(ActionEvent event) {
        if (this.getSelected() != null && idCompany.getSelected() == null) {
            idCompany.setSelected(this.getSelected().getIdCompany());
        }
    }

    public void saveSectionCompany(String condition) {

        if (condition != null && ConditionType.NEW.getNameCondition().equals(condition)) {
            saveNew(null);
            operation = OperationType.CREATE.getOperationName();
        } else {
            save(null);
            operation = OperationType.EDIT.getOperationName();
        }

        if (uploadImage != null && !uploadImage.isEmpty()) {
            for (UploadedFile file : uploadImage) {
                uploadListener(file, false, operation);
            }
            getSelected().setAttachmentFileList(attachmentList);
        }
    }

    /**
     * MEtodo encargado de crear un registro attachment por cada archivo
     *
     * @param file
     */
    public void uploadListener(UploadedFile file, boolean temp, String operation) {
        boolean done = false;
        AttachmentFile attachment;
        File result;
        String value = null;

        String fileExtension = file.getFileName().split("\\.")[file.getFileName().split("\\.").length - 1];
        String fileName = file.getFileName().substring(0, file.getFileName().indexOf(".")) + System.currentTimeMillis();

        FacesContext facesContext = FacesContext.getCurrentInstance();

        String pathUpload = facesContext.getExternalContext().getRealPath(UPLOAD_DIRECTORY_IMAGE_RELATIVE);

        HttpServletRequest request = (HttpServletRequest) facesContext.getExternalContext().getRequest();
        String baseURL = request.getRequestURL().toString().replace(request.getPathInfo(), "") + UPLOAD_DIRECTORY_IMAGE_RELATIVE;

        try {
            if (!temp) {

                attachment = new AttachmentFile();
                attachment.setNameFile(file.getFileName());
                attachment.setDescription(file.getFileName());
                attachment.setPathFile(UPLOAD_DIRECTORY_IMAGE_RELATIVE + File.separator + fileName + "." + fileExtension);
                attachment.setFileSize(String.valueOf(file.getSize()));
                attachment.setExtentionFile(file.getContentType());
                attachment.setIdSectionCompany(getSelected());

                done = false;

                try {
                    attachmentFileFacade.edit(attachment);
                    done = true;
                    attachmentList.add(attachment);
                } catch (Exception e) {
                    FacesMessage error = new FacesMessage("Error persistence");
                    FacesContext.getCurrentInstance().addMessage(null, error);
                }
            }

            // TODO evaluar path definitivo donde se guardaran los archivos cargados para cada section
            //String path = facesContext.getExternalContext().getRealPath(UPLOAD_DIRECTORY);
            File uploadFolder = new File(pathUpload);

            if (!uploadFolder.exists()) {
                uploadFolder.mkdir();
            }

            if (temp) {
                result = File.createTempFile(fileName, "." + fileExtension, uploadFolder);
            } else {
                result = new File(uploadFolder + File.separator + fileName + "." + fileExtension);
            }

            FileOutputStream fileOutputStream = new FileOutputStream(result);
            byte[] buffer = new byte[1024];
            int bulk;

            InputStream inputStream = file.getInputstream();
            while (true) {
                bulk = inputStream.read(buffer);
                if (bulk < 0) {
                    break;
                }

                fileOutputStream.write(buffer, 0, bulk);
                fileOutputStream.flush();
            }

            fileOutputStream.close();
            inputStream.close();
            
            
            if (form != null) {
                RequestContext.getCurrentInstance().update(form);
            }

            if (operation != null && operation.equals(OperationType.CREATE.getOperationName())) {
                value = FacesContext.getCurrentInstance().
                        getExternalContext().getRequestParameterMap().get("SectionCompanyCreateForm:paragraph_input");
                form = "SectionCompanyCreateForm:paragraph_input";
            } else {
                value = FacesContext.getCurrentInstance().
                        getExternalContext().getRequestParameterMap().get("SectionCompanyEditForm:paragraph_input");
                form = "SectionCompanyEditForm:paragraph_input";
            }
            if (value.contains(imageUrl.toString())) {
                imageUrl = new StringBuilder();
            }

            imageUrl.append("<img src='").append(baseURL).append(result.getName()).append("' />");
            getSelected().setParagraph(value + imageUrl.toString());
            RequestContext.getCurrentInstance().update(form);
        } catch (IOException e) {
            e.printStackTrace();
            FacesMessage error = new FacesMessage("The files were not uploaded!");
            FacesContext.getCurrentInstance().addMessage(null, error);
        }

    }

    public void fillParagraph(String paragraph) {
        setParagraph(paragraph);
    }

    public String getParagraph() {
        return paragraph;
    }

    public void setParagraph(String paragraph) {
        this.paragraph = paragraph;
    }

    public void loadImageTemp(FileUploadEvent image) {
        uploadImage.add(image.getFile());
        uploadListener(image.getFile(), true, operation);
    }

    public void changeSelection(SectionCompany item) {
        setSelected(item);
        setParagraph(item.getParagraph());
    }

    public String getSizeLimit() {
        return configurationMasterParameter.getParameter(ConfigurationMasterParameter.CONF_SIZE_LIMIT_FILE_UPLOAD);
    }

    public String getAllowTypes() {
        return this.configurationMasterParameter.getParameter(ConfigurationMasterParameter.CONF_ALLOW_TYPES_FILE_UPLOAD);
    }

    public void fillOperation(String operation) {
        this.operation = operation;
    }

}
