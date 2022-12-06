package classes;

public class Book {
    private String _author; // variables
    private String _data;

    public Book(){
        _author = "Kalinin Aleksandr";
        _data = "02/09/2022";
    }

    public Book(String newAuthor, String newData){
        _author = newAuthor;
        _data = newData;
    }

    public void setAuthor(String a){
        _author = a;
    }

    public void setData(String a){
        _data = a;
    }

    public String getAuthor(){
        return _author;
    }

    public String getData(){
        return _data;
    }

    public String toString(){
        return "Автор книги: " + this._author + ". Дата издания: " + this._data;
    }
}