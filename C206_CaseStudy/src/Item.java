/**
 * I declare that this code was written by me.
 * I will not copy or allow others to copy my code.
 * I understand that copying code is considered as plagiarism.
 *
 * 20010174, 3 Aug 2021 8:57:34 pm
 */

/**
 * @author 20010174
 *
 */
public class Item {

  private String itemname;
  private String desc;
  private double minBid;
  private String startDate;
  private String endDate;
  private double bidIncre;
  
  public Item(String itemname, String desc, double minBid, String startDate, String endDate, double bidIncre) {
    this.itemname = itemname;
    this.desc = desc;
    this.minBid = minBid;
    this.startDate = startDate;
    this.endDate = endDate;
    this.bidIncre = bidIncre;
        
  }
  

  public String getItemname() {
    return itemname;
  }

  public void setItemname(String itemname) {
    this.itemname = itemname;
  }

  public String getStartDate() {
    return startDate;
  }

  public void setStartDate(String startDate) {
    this.startDate = startDate;
  }

  public String getEndDate() {
    return endDate;
  }

  public void setEndDate(String endDate) {
    this.endDate = endDate;
  }

  public double getBidIncre() {
    return bidIncre;
  }

  public void setBidIncre(double bidIncre) {
    this.bidIncre = bidIncre;
  }

  public String getDesc() {
    return desc;
  }


  public double getMinBid() {
    return minBid;
  }


  public void setDesc(String desc) {
    this.desc = desc;
  }

  public void setMinBid(double minBid) {
    this.minBid = minBid;
  }
}
