package cn.lpctstr.node.data.util;

/**
 * @Author:LPCTSTR_MSR
 * @Description: Null
 * @Date: 11:23 2019/8/6
 * @Project: ZJSRTP
 */
public interface ArrayMerkleTreeNode {
    String getLocalHash();

    String getlChildHash();

    String getrChildHash();

    String getGeneralHash();

    void setValue(Object o);

    void setlChildHash(String hash);

    void setrChildHash(String hash);
}
