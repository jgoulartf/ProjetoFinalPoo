package br.com.informatica.dao;

public class DAOFactory {

    public static ClienteDAO getClienteDao() {
        return new ClienteXMLDAO();
    }

    public static EquipamentoDAO getEquipamentoDAO() {
        return new EquipamentoXMLDAO();
    }

    public static ResponsavelDAO getResponsavelDAO() {
        return new ResponsavelXMLDAO();
    }

    public static UserDAO getUserDao() {
        return new UserXMLDAO();
    }

}
