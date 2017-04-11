/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package faces.entities;

import javax.json.Json;
import javax.json.JsonObject;

/**
 *
 * @author c0687631
 */
public class tags {

    private int tag_id;
    private String tag_name;

    public tags(int tag_id, String tag_name) {
        this.tag_id = tag_id;
        this.tag_name = tag_name;
    }

    public int getTag_id() {
        return tag_id;
    }

    public void setTag_id(int tag_id) {
        this.tag_id = tag_id;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }

    public JsonObject toJson() {
        return Json.createObjectBuilder()
                .add("tag_id", tag_id)
                .add("tag_name", tag_name)
                .build();
    }

}
