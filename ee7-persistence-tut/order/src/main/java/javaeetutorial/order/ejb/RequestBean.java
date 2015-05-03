package javaeetutorial.order.ejb;

import javaeetutorial.order.entity.CustomerOrder;
import javaeetutorial.order.entity.LineItem;
import javaeetutorial.order.entity.Part;

import javax.ejb.Local;
import java.io.Serializable;
import java.util.List;

/**
 * Created by x on 5/2/15.
 */
@Local
public interface RequestBean {
    void createPart(String partNumber,
                    int revision,
                    String description,
                    java.util.Date revisionDate,
                    String specification,
                    Serializable drawing);

        List<Part> getAllParts();

        void addPartToBillOfMaterial(String bomPartNumber,
                                     int bomRevision,
                                     String partNumber,
                                     int revision);

        void createVendor(int vendorId,
                          String name,
                          String address,
                          String contact,
                          String phone);

        void createVendorPart(String partNumber,
                              int revision,
                              String description,
                              double price,
                              int vendorId);

        void createOrder(Integer orderId, char status, int discount, String shipmentInfo);

        List<CustomerOrder> getOrders();

        void addLineItem(Integer orderId, String partNumber, int revision, int quantity);

        double getBillOfMaterialPrice(String bomPartNumber, int bomRevision, String partNumber, int revision);

        double getOrderPrice(Integer orderId);

        void adjustOrderDiscount(int adjustment);

        Double getAvgPrice();

        Double getTotalPricePerVendor(int vendorId);

        List<String> locateVendorsByPartialName(String name);

        int countAllItems();

        List<LineItem> getLineItems(int orderId);

        void removeOrder(Integer orderId);

        String reportVendorsByOrder(Integer orderId);
}
