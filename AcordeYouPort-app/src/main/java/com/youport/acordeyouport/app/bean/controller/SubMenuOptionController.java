package com.youport.acordeyouport.app.bean.controller;

import com.youport.acordeyouport.app.entity.SubMenuOption;
import javax.faces.event.ActionEvent;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "subMenuOptionController")
@ViewScoped
public class SubMenuOptionController extends AbstractController<SubMenuOption> {

    @Inject
    private ViewController viewController;
    @Inject
    private MenuOptionController menuOptionController;

    public SubMenuOptionController() {
        // Inform the Abstract parent controller of the concrete SubMenuOption Entity
        super(SubMenuOption.class);
    }

    /**
     * Resets the "selected" attribute of any parent Entity controllers.
     */
    public void resetParents() {
        viewController.setSelected(null);
        menuOptionController.setSelected(null);
    }

    /**
     * Sets the "selected" attribute of the View controller in order to display
     * its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareView(ActionEvent event) {
        if (this.getSelected() != null && viewController.getSelected() == null) {
            viewController.setSelected(this.getSelected().getIdView());
        }
    }

    /**
     * Sets the "selected" attribute of the MenuType controller in order to
     * display its data in its View dialog.
     *
     * @param event Event object for the widget that triggered an action
     */
    public void prepareMenuOption(ActionEvent event) {
        if (this.getSelected() != null && menuOptionController.getSelected() == null) {
            menuOptionController.setSelected(this.getSelected().getIdMenu());
        }
    }

}
