package com.lehi.megasorte;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Lehi on 03/09/2016.
 */
public class SecoesAdapter extends FragmentPagerAdapter{

    private Map<Integer,String> mFragmentTags;
    private FragmentManager mFragmentManager;
    private Context mContext;

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */

        public SecoesAdapter(FragmentManager fm,Context context) {
            super(fm);
            mFragmentManager = fm;
            mFragmentTags = new HashMap<Integer,String>();
            mContext = context;

        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).

            if (position == 0) {
                return new Jogos();
            } else if (position == 1) {
                return new MeusJogos();
            } else if (position ==2){
                return new Bolao();
            }else{
                return new Valor();
            }

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "Jogar";
                case 1:
                    return "Meus Jogos";
                case 2:
                    return "Bolão";
                case 3:
                    return "Valor";
            }
            return null;
        }

    // Descobre a Tag e insere
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object obj = super.instantiateItem(container, position);

        Fragment f = (Fragment) obj;
        String tag = f.getTag();
        mFragmentTags.put(position,tag);

        return obj;
    }

    //Retorna o fragmento selecionado
    public Fragment getFragment(int position){
        String tag = mFragmentTags.get(position);
        if (tag==null)
            return null;
            return  mFragmentManager.findFragmentByTag(tag);
    }


}
