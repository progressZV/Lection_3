package com.senla.console.actions.ServiceActions;

import com.senla.console.actions.IAction;
import com.senla.facade.AdministratorService;

public class GetServicesAction implements IAction {
    @Override
    public void execute() {
        AdministratorService administratorService = new AdministratorService();
        administratorService.checkAllServices();
    }
}
