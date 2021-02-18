package headfisrt.A9_templateModel.jdbc;

import headfisrt.A9_templateModel.jdbc.dao.MemberDao;

import java.util.List;

public class MemberDaoTest {

    public static void main(String[] args) {
        MemberDao memberDao = new MemberDao(null);
        List<?> result = memberDao.selectAll();
        System.out.println(result);
    }
}
