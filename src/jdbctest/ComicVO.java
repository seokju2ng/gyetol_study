package jdbctest;

public class ComicVO {
    int id;
    String title;
    int price;
    String categoryCode;
    String publisherCode;

    public ComicVO(int id, String title, int price, String categoryCode, String publisherCode) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.categoryCode = categoryCode;
        this.publisherCode = publisherCode;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getPublisherCode() {
        return publisherCode;
    }

    public void setPublisherCode(String publisherCode) {
        this.publisherCode = publisherCode;
    }

    @Override
    public String toString() {
        return "ComicVO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", categoryCode='" + categoryCode + '\'' +
                ", publisherCode='" + publisherCode + '\'' +
                '}';
    }
}
