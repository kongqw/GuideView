package com.kongqw.sample.guide.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.kongqw.guide.Component;
import com.kongqw.guide.Guide;
import com.kongqw.guide.GuideBuilder;
import com.kongqw.sample.guide.R;
import com.kongqw.sample.guide.component.LottieComponent;
import com.kongqw.sample.guide.component.MutiComponent;
import com.kongqw.sample.guide.component.SimpleComponent;

public class SimpleGuideViewActivity extends Activity {

  private Button header_imgbtn;
  private LinearLayout ll_nearby, ll_video;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_simple_guide_view);
    header_imgbtn = findViewById(R.id.header_imgbtn);
    header_imgbtn.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Toast.makeText(SimpleGuideViewActivity.this, "show", Toast.LENGTH_SHORT).show();
      }
    });
    ll_nearby = findViewById(R.id.ll_nearby);
    ll_video = findViewById(R.id.ll_video);
    header_imgbtn.post(new Runnable() {
      @Override
      public void run() {
        showGuideView();
      }
    });
  }

  public void showGuideView() {
    GuideBuilder builder = new GuideBuilder();
    builder.setTargetView(header_imgbtn)
            .setAlpha(150)
            .setHighTargetCorner(20)
            .setHighTargetPadding(10);
    builder.setOnVisibilityChangedListener(new GuideBuilder.OnVisibilityChangedListener() {
      @Override
      public void onShown() {
      }

      @Override
      public void onDismiss() {
        showGuideView2();
      }
    });

    builder.addComponent(new SimpleComponent());
    Guide guide = builder.createGuide();
    guide.show(SimpleGuideViewActivity.this);
  }

  public void showGuideView2() {
    final GuideBuilder builder1 = new GuideBuilder();
    builder1.setTargetView(ll_nearby)
            .setAlpha(150)
            .setHighTargetGraphStyle(Component.CIRCLE);
    builder1.setOnVisibilityChangedListener(new GuideBuilder.OnVisibilityChangedListener() {
      @Override
      public void onShown() {
      }

      @Override
      public void onDismiss() {
        showGuideView3();
      }
    });

    builder1.addComponent(new MutiComponent());
    Guide guide = builder1.createGuide();
    guide.show(SimpleGuideViewActivity.this);
  }

  public void showGuideView3() {
    final GuideBuilder builder1 = new GuideBuilder();
    builder1.setTargetView(ll_video)
            .setAlpha(150)
            .setHighTargetCorner(20)
            .setHighTargetPadding(10)
            .setExitAnimationId(android.R.anim.fade_out);
    builder1.setOnVisibilityChangedListener(new GuideBuilder.OnVisibilityChangedListener() {
      @Override
      public void onShown() {
      }

      @Override
      public void onDismiss() {
      }
    });

    builder1.addComponent(new LottieComponent());
    Guide guide = builder1.createGuide();
    guide.setShouldCheckLocInWindow(false);
    guide.show(SimpleGuideViewActivity.this);
  }
}
