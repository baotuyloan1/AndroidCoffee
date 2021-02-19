package com.example.appbanhang.Activity.CheckOut;

import com.example.appbanhang.Activity.Fragment.CartFragment;
import com.example.appbanhang.Model.GioHang;
import com.example.appbanhang.Model.UserAccount;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ContentEmail {

    private ArrayList<GioHang> gioHang;
    private String note;
    private String htmlDetailGioHang;
    private String maDonHang;

    private UserAccount user;

    public ContentEmail(ArrayList<GioHang> gioHang, String note, String maDonHang, UserAccount user) {
        this.gioHang = gioHang;
        this.note = note;
        this.maDonHang = maDonHang;
        this.user = user;
    }


    public void DetailGioHang() {
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        htmlDetailGioHang = "";
        for (int i = 0; i < gioHang.size(); i++) {
            htmlDetailGioHang = htmlDetailGioHang + "<tr>" +
                    "<td align=\"left\" valign=\"top\" style=\"width:120px;font-family:Arial,Helvetica,sans-serif;font-size:12px;color:#666666;padding-left:15px;padding-right:10px;line-height:10px;padding-bottom:5px\"> \n" +
                    "<b>Sản phẩm</b>\n" +
                    "</td>\n" +
                    "<td align=\"left\" valign=\"top\" style=\"font-family:Arial,Helvetica,sans-serif;font-size:12px;color:#666666;line-height:20px;padding-bottom:5px\">:</td>\n" +
                    " <td align=\"left\" valign=\"top\" style=\"font-family:Arial,Helvetica,sans-serif;font-size:12px;color:#666666;line-height:20px;padding-left:10px;padding-bottom:5px\">\n" +
                    "<a href=\"#\" style=\"color:#115fff;text-decoration:none\" target=\"_blank\">\n" +
                    gioHang.get(i).getTenSp() + " X " + gioHang.get(i).getSoLuong() +
                    "</a>" +
                    "</td>" +
                    "<td  valign=\"left\" valign=\"top\" style=\"font-family:Arial,Helvetica,sans-serif;font-size:12px;color:#666666;line-height:20px;padding-bottom:5px\">\n" +
                    "<a href=\"#\" style=\"color:#115fff;text-decoration:none\" target=\"_blank\">\n" +
                    decimalFormat.format(gioHang.get(i).getGiaSp()) + "Đ" +
                    "</a>" +
                    "</td>" +
                    "</tr>";
        }
    }

    public String ContentEmailHtml() {
        DetailGioHang();
        String htmlCode = "<div marginheight=\"0\" marginwidth=\"0\" style=\"background:#f0f0f0\">\n" +
                " <div id=\"wrapper\" style=\"background-color:#f0f0f0\">" +
                "        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\" style=\"margin:0 auto;width:600px!important;min-width:600px!important\" class=\"container\">\n" +
                "            <tbody>" +
                "                <tr>" +
                "                    <td align=\"center\" valign=\"middle\" style=\"background:#ffffff\">" +
                "                        <table style=\"width:580px;border-bottom:1px solid #ff3333\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "                            <tbody>" +
                "                                <tr>\n" +
                "                                    <td align=\"left\" valign=\"middle\" style=\"width:500px;height:60px\">\n" +
                "                                        <a href=\"#\" style=\"border:0\" target=\"_blank\" width=\"130\" height=\"35\" style=\"display:block;border:0px\">\n" +
                "                                            <img src=\"https://firebasestorage.googleapis.com/v0/b/bt-sict.appspot.com/o/cafe.png?alt=media&token=8bb5387a-d350-466e-85e7-6b55646b56b3\" height=\"100\" width=\"115\" style=\"display:block;border:0px;float: left;\"> <b style=\"float: left;line-height: 100px;color: red;font-size: 20px;\">Coffee Shop</b>\n" +
                "                                        </a>\n" +
                "                                    </td>\n" +
                "                                    <td align=\"right\" valign=\"middle\" style=\"padding-right:15px\">\n" +
                "                                        <a href=\"\" style=\"border:0\"> \n" +
                "                                            <img src=\"https://i.imgur.com/eL1uAJx.png\" height=\"36\" width=\"115\" style=\"display:block;border:0px\"> \n" +
                "                                        </a>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td align=\"center\" valign=\"middle\" style=\"background:#ffffff\">\n" +
                "                        <table style=\"width:580px\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td align=\"left\" valign=\"middle\" style=\"font-family:Arial,Helvetica,sans-serif;font-size:24px;color:#ff3333;text-transform:uppercase;font-weight:bold;padding:25px 10px 15px 10px\">\n" +
                "                                        Thông báo đặt hàng thành công\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                                <tr>\n" +
                "                                    <td align=\"left\" valign=\"middle\" style=\"font-family:Arial,Helvetica,sans-serif;font-size:12px;color:#666666;padding:0 10px 20px 10px;line-height:17px\">\n" +
                "                                        Chào " + user.getFullName() + ",\n" +
                "                                        <br> Cám ơn bạn đã mua sắm tại Coffee Shop\n" +
                "                                        <br>\n" +
                "                                        <br> Đơn hàng của bạn đang \n" +
                "                                        <b>chờ shop</b>  \n" +
                "                                        <b>xác nhận</b> (trong vòng 24h)\n" +
                "                                        <br> Chúng tôi sẽ thông tin <b>trạng thái đơn hàng</b> trong email tiếp theo.\n" +
                "                                        <br> Bạn vui lòng kiểm tra email thường xuyên nhé.\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td align=\"center\" valign=\"middle\" style=\"background:#ffffff\">\n" +
                "                        <table style=\"width:580px;border:1px solid #ff3333;border-top:3px solid #ff3333\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td colspan=\"2\" align=\"left\" valign=\"top\" style=\"font-family:Arial,Helvetica,sans-serif;font-size:14px;color:#666666;padding:10px 10px 20px 15px;line-height:17px\"> \n" +
                "                                        <b>Đơn hàng của bạn #</b> \n" +
                "                                        <a href=\"#\" style=\"color:#ed2324;font-weight:bold;text-decoration:none\" target=\"_blank\">" + this.maDonHang + "\n" +
                "                                        </a>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                                <tr>\n" +
                "                                     <td align=\"left\" valign=\"top\" style=\"width:120px;padding-left:15px\">\n" +
                "                                        <a href=\"#_\" style=\"border:0\"> \n" +
                "                                            <img src=\"https://firebasestorage.googleapis.com/v0/b/bt-sict.appspot.com/o/coffeeshoplogo.png?alt=media&token=519de95e-e76e-4737-bc89-74ca83b53bbf\" height=\"120\" width=\"120\" style=\"display:block;border:0px\"> \n" +
                "                                        </a>\n" +
                "                                    </td> \n" +
                "                                    <td align=\"left\" valign=\"top\">\n" +
                "                                        <table style=\"width:100%\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "                                           \n" +
                "                                            <tbody>\n" +
                htmlDetailGioHang
                +
                "                                                <tr>\n" +
                "                                                    <td align=\"left\" valign=\"top\" style=\"width:120px;font-family:Arial,Helvetica,sans-serif;font-size:12px;color:#666666;padding-left:15px;padding-right:10px;line-height:20px;padding-bottom:5px\"> \n" +
                "                                                        <b>Tên Shop</b>\n" +
                "                                                    </td>\n" +
                "                                                    <td align=\"left\" valign=\"top\" style=\"font-family:Arial,Helvetica,sans-serif;font-size:12px;color:#666666;line-height:20px;padding-bottom:5px\">:</td>\n" +
                "                                                    <td align=\"left\" valign=\"top\" style=\"font-family:Arial,Helvetica,sans-serif;font-size:12px;color:#666666;line-height:20px;padding-left:10px;padding-bottom:5px\"> \n" +
                "                                                        <a href=\"#\" style=\"color:#115fff;text-decoration:none\" target=\"_blank\">\n" +
                "                                                           COFFEE SHOP\n" +
                "                                                        </a>\n" +
                "                                                        - 0788049042\n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                                <tr>\n" +
                "                                                    <td align=\"left\" valign=\"top\" style=\"width:120px;font-family:Arial,Helvetica,sans-serif;font-size:12px;color:#666666;line-height:20px;padding-left:15px;padding-right:10px;padding-bottom:5px\"> \n" +
                "                                                        <b>Tổng thanh toán</b>\n" +
                "                                                    </td>\n" +
                "                                                    <td align=\"left\" valign=\"top\" style=\"font-family:Arial,Helvetica,sans-serif;font-size:12px;color:#666666;line-height:20px;padding-bottom:5px\">:</td>\n" +
                "                                                    <td align=\"left\" valign=\"top\" style=\"font-family:Arial,Helvetica,sans-serif;font-size:12px;color:#666666;line-height:20px;padding-left:10px;padding-bottom:5px\">\n" +
                CartFragment.txtTongTien.getText() +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                                <tr>\n" +
                "                                                    <td align=\"left\" valign=\"top\" style=\"width:120px;font-family:Arial,Helvetica,sans-serif;font-size:12px;color:#666666;line-height:20px;padding-left:15px;padding-right:10px;padding-bottom:5px\"> \n" +
                "                                                        <b>Người nhận</b>\n" +
                "                                                    </td>\n" +
                "                                                    <td align=\"left\" valign=\"top\" style=\"font-family:Arial,Helvetica,sans-serif;font-size:12px;color:#666666;line-height:20px;padding-bottom:5px\">:</td>\n" +
                "                                                    <td align=\"left\" valign=\"top\" style=\"font-family:Arial,Helvetica,sans-serif;font-size:12px;color:#666666;line-height:20px;padding-left:10px;padding-bottom:5px\"> \n" +
                "                                                    <b>" + user.getFullName() + "</b> " + user.getPhoneNumber() + "\n" +
                "                                                        <br>\n" +
                "                                                        " + user.getAddress() +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                                <tr>\n" +
                "                                                    <td align=\"left\" valign=\"top\" style=\"width:120px;font-family:Arial,Helvetica,sans-serif;font-size:12px;color:#666666;line-height:20px;padding-left:15px;padding-right:10px;padding-bottom:5px\"> \n" +
                "                                                        <b>Lời nhắn</b>\n" +
                "                                                    </td>\n" +
                "                                                    <td align=\"left\" valign=\"top\" style=\"font-family:Arial,Helvetica,sans-serif;font-size:12px;color:#666666;line-height:20px;padding-bottom:5px\">:</td>\n" +
                "                                                    <td align=\"left\" valign=\"top\" style=\"font-family:Arial,Helvetica,sans-serif;font-size:12px;color:#666666;line-height:20px;padding-left:10px;padding-bottom:5px\"> \n" +
                "                                                    <b>"+note+"</b> \n" +
                "                                                    \n" +
                "                                                    </td>\n" +
                "                                                </tr>\n" +
                "                                            </tbody>\n" +
                "                                        </table>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                                <tr>\n" +
                "                                    <td colspan=\"2\" align=\"center\" valign=\"top\" style=\"padding-top:20px;padding-bottom:20px;border-bottom:1px solid #ebebeb\">\n" +
                "                                        <a href=\"#\" style=\"border:0px\" target=\"_blank\"> \n" +
                "                                       \n" +
                "                                        </a>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td align=\"center\" valign=\"middle\" style=\"background:#ffffff;padding-top:20px\">\n" +
                "                        <table style=\"width:500px\" cellpadding=\"0\" cellspacing=\"0\" border=\"0\">\n" +
                "                            <tbody>\n" +
                "                                <tr>\n" +
                "                                    <td align=\"center\" valign=\"middle\" style=\"font-family:Arial,Helvetica,sans-serif;font-size:12px;color:#666666;line-height:20px;padding-bottom:5px\"> \n" +
                "                                        Đây là thư tự động từ hệ thống. Vui lòng không trả lời email này.\n" +
                "                                        <br> Nếu có bất kỳ thắc mắc hay cần giúp đỡ, Bạn vui lòng ghé thăm \n" +
                "                                        <b style=\"font-family:Arial,Helvetica,sans-serif;font-size:13px;text-decoration:none;font-weight:bold\">Trung tâm trợ giúp</b> của chúng tôi tại địa chỉ: \n" +
                "                                        <a href=\"#\" style=\"font-family:Arial,Helvetica,sans-serif;font-size:13px;color:#0066cc;text-decoration:none;font-weight:bold\" target=\"_blank\">\n" +
                "                                            coffeeshop.doan2@gmail.com\n" +
                "                                        </a>\n" +
                "                                    </td>\n" +
                "                                </tr>\n" +
                "                            </tbody>\n" +
                "                        </table>\n" +
                "                    </td>\n" +
                "                </tr>\n" +
                "            </tbody>\n" +
                "        </table>\n" +
                "    </div> \n" +
                "</div>";
        return htmlCode;
    }


}
