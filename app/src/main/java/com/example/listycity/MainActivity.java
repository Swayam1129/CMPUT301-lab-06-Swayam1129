package com.example.listycity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


/**
 * The main entry point of the ListyCity application.
 * <p>
 * This activity is launched when the app starts. It initializes the user interface
 * by setting the layout defined in {@code activity_main.xml} and applies system window
 * insets to ensure proper layout behavior on devices with notches, navigation bars, or
 * status bars.
 * </p>
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Called when the activity is first created.
     * <p>
     * This method sets up the layout for the activity and configures
     * edge-to-edge rendering, ensuring the app’s content adjusts
     * for system UI components like the status and navigation bars.
     * </p>
     *
     * @param savedInstanceState A {@link Bundle} object containing the activity's
     *                           previously saved state, if any.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}