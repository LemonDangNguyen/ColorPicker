package com.example.colorpicker

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import yuku.ambilwarna.AmbilWarnaDialog
import yuku.ambilwarna.AmbilWarnaDialog.OnAmbilWarnaListener

class MainActivity : AppCompatActivity() {
    // Text view variable to set the color for GFG text
    private lateinit var gfgTextView: TextView

    // Two buttons to open color picker dialog and one to set the color for GFG text
    private lateinit var mSetColorButton: Button
    private lateinit var mPickColorButton: Button

    // View box to preview the selected color
    private lateinit var mColorPreview: View

    // This is the default color of the preview box
    private var mDefaultColor = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Register the GFG text with appropriate ID
        gfgTextView = findViewById(R.id.gfg_heading)

        // Register two of the buttons with their appropriate IDs
        mPickColorButton = findViewById(R.id.pick_color_button)
        mSetColorButton = findViewById(R.id.set_color_button)

        // Also register the view which shows the preview of the color chosen by the user
        mColorPreview = findViewById(R.id.preview_selected_color)

        // Set the default color to 0 as it is black
        mDefaultColor = 0

        // Button to open the AmbilWarna color picker dialog
        mPickColorButton.setOnClickListener {
            openColorPickerDialogue()
        }

        // Button to set the color of GFG text
        mSetColorButton.setOnClickListener {
            // Use the mDefaultColor to set the text color
            gfgTextView.setTextColor(mDefaultColor)
        }
    }

    // The dialog functionality is handled separately using openColorPickerDialogue
    fun openColorPickerDialogue() {
        // The AmbilWarnaDialog callback needs 3 parameters
        val colorPickerDialogue = AmbilWarnaDialog(this, mDefaultColor,
            object : OnAmbilWarnaListener {
                override fun onCancel(dialog: AmbilWarnaDialog?) {
                    // Leave this function body blank, as the dialog
                    // automatically closes when clicked on cancel button
                }

                override fun onOk(dialog: AmbilWarnaDialog?, color: Int) {
                    // Change the mDefaultColor to change the GFG text color
                    mDefaultColor = color

                    // Now change the picked color preview box to mDefaultColor
                    mColorPreview.setBackgroundColor(mDefaultColor)
                }
            })
        colorPickerDialogue.show()
    }
}
