package cn.lpctstr.node.data.model;

import cn.hutool.core.lang.UUID;
import cn.lpctstr.node.data.AbstractDataInfo;
import cn.lpctstr.node.data.util.SHA256_Encoder;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Maybe move into the internal of the @Stud_Info
 * @Date: 18:56 2019/6/25
 * @Project: ZJSRTP
 */
public class Course extends AbstractDataInfo {
    private String name;
    private int priority;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    private String hash;

    /**
     * @param name     The name of the course
     * @param priority The priority tags the importance of the course
     * @param hash     The unique string used for validity.
     */
    public Course(String name, int priority, String hash) {
        this.name = name;
        this.priority = priority;
        this.hash = hash;
    }

    /**
     * @param name
     * @param hash Priority default is 5
     */
    public Course(String name, String hash) {
        this(name, 5, hash);
    }
    public Course(String name) {
        this(name, 5, SHA256_Encoder.generateSHA256(UUID.fastUUID().toString()));
    }

}
