package fullNbfcJdbc.EmiDao;

import fullNbfcJdbc.entity.Emi;

import java.util.List;

public interface EmiDao {
        void save(Emi emi);
        Emi findById(int emi_id);
        List<Emi> findall();
        void update(Emi emi);
        void deleteById(int id);
        void markAsPaid(int id,boolean paid);
        void findPendingsEmis();

}
