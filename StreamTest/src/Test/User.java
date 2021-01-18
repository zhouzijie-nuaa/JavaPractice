package Test;

import java.io.Serializable;

/**
 * author: zijiezhou
 * Date:   2020/8/31 15:06
 * Description:
 */
public class User implements Serializable {
    private int id;
    private String name;

    public User(int id,String name) {
        this.id=id;
        this.name=name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
