package IMFramework.fragment;



import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class IFragment  extends Fragment {



  public IFragment(Fragment fragment, AppCompatActivity activity, int idLayout) {

    FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
    fragmentTransaction.replace(idLayout,fragment);
    fragmentTransaction.commit();


  }
}
