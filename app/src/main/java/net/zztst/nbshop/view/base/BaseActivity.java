    package net.zztst.nbshop.view.base;

    import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;


    /**
     * Created by Arron on 16/6/28.
     */
    public abstract class BaseActivity extends AppCompatActivity {
        //动态获取类名 打印日志使用
        protected String TAG = this.getClass().getSimpleName();

        //布局文件ID
        protected abstract int getContentViewId();

        /**
         * 布局中Fragment的ID
         * 如果没有fragment则不必实现
         */
        protected abstract int getFragmentContentId();

        //添加fragment
        protected void addFragment(BaseFragment fragment) {
            if (fragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(getFragmentContentId(), fragment, fragment.getClass().getSimpleName())
                        .addToBackStack(fragment.getClass().getSimpleName())
                        .commitAllowingStateLoss();
            }
        }

        //移除fragment
        protected void removeFragment() {
            if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
                getSupportFragmentManager().popBackStack();
            } else {
                finish();
            }
        }

        //返回键返回事件的处理
        //如果FragmentStack中只有1个fragment 关闭当前activity
        // 如果FragmentStack中还有>1数量fragment则可以removeFragment()将fragment出栈 此部分交给子类实现
        @Override
        public boolean onKeyDown(int keyCode, KeyEvent event) {
            if (KeyEvent.KEYCODE_BACK == keyCode) {
                if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                    finish();
                    return true;
                }
            }
            return super.onKeyDown(keyCode, event);
        }

        @Override
        protected void onStop() {
            super.onStop();
        }

    }
