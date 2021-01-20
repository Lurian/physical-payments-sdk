package sdk.android.seed;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MockInStoreActivity extends Activity {

  private TextView textView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.instore);
    textView = (TextView) findViewById(R.id.instore_intent_text_view);

    Bundle extras = getIntent().getExtras();
    if (extras != null) {
      String allExtras = "";
      for (String key : extras.keySet()) {
        allExtras = allExtras.concat(key + " : " + extras.getString(key) + "\n");
      }
      textView.setText(allExtras);
    }
  }

  public void onSendPaymentRequest(View view) {
    Intent sendPaymentIntent = MockUtils.getMockPaymentRequestIntent();
    startActivity(sendPaymentIntent);
  }

  public void onSendPaymentReversalRequest(View view) {
    Intent sendPaymentReversalIntent = MockUtils.getMockPaymentReversalRequestIntent();
    startActivity(sendPaymentReversalIntent);
  }
}
