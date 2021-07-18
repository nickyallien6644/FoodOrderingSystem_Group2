package com.example.apimysql.Service;

import com.example.apimysql.DAO.NotificationDAO;
import com.example.apimysql.Interface.NotificationInterface;

import com.example.apimysql.Model.Cart;
import com.example.apimysql.Model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class NoficationService implements NotificationInterface {

    @Autowired
    NotificationDAO dao;

    @Override
    public List<Map<String, Object>> ListNofication(String ID) {
        return dao.ListNofication(ID);
    }


    @Override
    public int addNofication(Notification notification) {
        return dao.addNofication(notification);
    }
}
