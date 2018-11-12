package command;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProFoodOrderRecieverCommand implements Serializable{
   private int proFoodOrderRecieverNo;
   private String memberEmail;
   private String proFoodOrderRecieverName;
   private String ProFoodOrderRecieverPhone;
   private String proFoodOrderRecieverAddr1;
   private String proFoodOrderRecieverAddr2;
   private int proFoodOrderRecieverAddrNo;
   private int proFoodOrderRecieverTotal;
   
   public ProFoodOrderRecieverCommand() {
      
   }
   
   public ProFoodOrderRecieverCommand(int proFoodOrderRecieverNo, String memberEmail, String proFoodOrderRecieverName,
         String proFoodOrderRecieverPhone, String proFoodOrderRecieverAddr1, String proFoodOrderRecieverAddr2,
         int proFoodOrderRecieverAddrNo, int proFoodOrderRecieverTotal) {
      super();
      this.proFoodOrderRecieverNo = proFoodOrderRecieverNo;
      this.memberEmail = memberEmail;
      this.proFoodOrderRecieverName = proFoodOrderRecieverName;
      ProFoodOrderRecieverPhone = proFoodOrderRecieverPhone;
      this.proFoodOrderRecieverAddr1 = proFoodOrderRecieverAddr1;
      this.proFoodOrderRecieverAddr2 = proFoodOrderRecieverAddr2;
      this.proFoodOrderRecieverAddrNo = proFoodOrderRecieverAddrNo;
      this.proFoodOrderRecieverTotal = proFoodOrderRecieverTotal;
   }

   public int getProFoodOrderRecieverNo() {
      return proFoodOrderRecieverNo;
   }
   public void setProFoodOrderRecieverNo(int proFoodOrderRecieverNo) {
      this.proFoodOrderRecieverNo = proFoodOrderRecieverNo;
   }
   public String getMemberEmail() {
      return memberEmail;
   }
   public void setMemberEmail(String memberEmail) {
      this.memberEmail = memberEmail;
   }
   public String getProFoodOrderRecieverName() {
      return proFoodOrderRecieverName;
   }
   public void setProFoodOrderRecieverName(String proFoodOrderRecieverName) {
      this.proFoodOrderRecieverName = proFoodOrderRecieverName;
   }
   public String getProFoodOrderRecieverPhone() {
      return ProFoodOrderRecieverPhone;
   }
   public void setProFoodOrderRecieverPhone(String proFoodOrderRecieverPhone) {
      ProFoodOrderRecieverPhone = proFoodOrderRecieverPhone;
   }
   public String getProFoodOrderRecieverAddr1() {
      return proFoodOrderRecieverAddr1;
   }
   public void setProFoodOrderRecieverAddr1(String proFoodOrderRecieverAddr1) {
      this.proFoodOrderRecieverAddr1 = proFoodOrderRecieverAddr1;
   }
   public String getProFoodOrderRecieverAddr2() {
      return proFoodOrderRecieverAddr2;
   }
   public void setProFoodOrderRecieverAddr2(String proFoodOrderRecieverAddr2) {
      this.proFoodOrderRecieverAddr2 = proFoodOrderRecieverAddr2;
   }
   public int getProFoodOrderRecieverAddrNo() {
      return proFoodOrderRecieverAddrNo;
   }
   public void setProFoodOrderRecieverAddrNo(int proFoodOrderRecieverAddrNo) {
      this.proFoodOrderRecieverAddrNo = proFoodOrderRecieverAddrNo;
   }
   public int getProFoodOrderRecieverTotal() {
      return proFoodOrderRecieverTotal;
   }
   public void setProFoodOrderRecieverTotal(int proFoodOrderRecieverTotal) {
      this.proFoodOrderRecieverTotal = proFoodOrderRecieverTotal;
   }
   
}