/**<ul>
 * <li>Cours4DialogDemo</li>
 * <li>com.android2ee.licence.cours4.demo.dialogs</li>
 * <li>10 févr. 2012</li>
 * 
 * <li>======================================================</li>
 *
 * <li>Projet : Mathias Seguy Project</li>
 * <li>Produit par MSE.</li>
 *
 /**
 * <ul>
 * Android Tutorial, An <strong>Android2EE</strong>'s project.</br> 
 * Produced by <strong>Dr. Mathias SEGUY</strong>.</br>
 * Delivered by <strong>http://android2ee.com/</strong></br>
 *  Belongs to <strong>Mathias Seguy</strong></br>
 ****************************************************************************************************************</br>
 * This code is free for any usage except training and can't be distribute.</br>
 * The distribution is reserved to the site <strong>http://android2ee.com</strong>.</br>
 * The intelectual property belongs to <strong>Mathias Seguy</strong>.</br>
 * <em>http://mathias-seguy.developpez.com/</em></br> </br>
 * 
 * *****************************************************************************************************************</br>
 *  Ce code est libre de toute utilisation mais n'est pas distribuable.</br>
 *  Sa distribution est reservée au site <strong>http://android2ee.com</strong>.</br> 
 *  Sa propriété intellectuelle appartient à <strong>Mathias Seguy</strong>.</br>
 *  <em>http://mathias-seguy.developpez.com/</em></br> </br>
 * *****************************************************************************************************************</br>
 */
package com.android2ee.licence.cours4.demo.dialogs;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * @author Mathias Seguy (Android2EE)
 * @goals
 *        This class aims to show how to use Dialogs with Android
 *        <ul>
 *        <li></li>
 *        </ul>
 */
public class Cours4DialogDemoActivity extends Activity {
	/**
	 * The tag for the log
	 */
	final static String tag = "DialogDemo";
	/******************************************************************************************/
	/** Attributes **************************************************************************/
	/******************************************************************************************/
	// The buttons
	/**
	 * The Button to show the AlertDialog
	 */
	private Button btnShowAD;
	/**
	 * The Button to show the AlertDialog With elements
	 */
	private Button btnShowADW;
	/**
	 * The Button to show the AlertDialog With checkBox
	 */
	private Button btnShowADWCB;
	/**
	 * The array of selected item of the AlertDialog with check box
	 */
	boolean[] checkedItems = { false, true, false, false };
	/**
	 * The Button to show the custom Alert Dialog without Title
	 */
	private Button btnShowCD;
	/**
	 * The Custom Dialog object
	 */
	private Dialog customDialog;
	/**
	 * The Button to show the custom Alert Dialog with Title
	 */
	private Button btnShowCAD;
	/**
	 * The Button to show the ProgressAlert Dialog
	 */
	private Button btnShowPD;
	/**
	 * The Button to show the ProgressAlert Dialog Indeterminate
	 */
	private Button btnShowPDI;
	/**
	 * The Button to show the custom Toast
	 */
	private Button btnToast;
	/******************************************************************************************/
	/** Constants **************************************************************************/
	/******************************************************************************************/

	/**
	 * The Constant to show the AlertDialog
	 */
	private final int AD = 0;
	/**
	 * The Constant to show the AlertDialog With elements
	 */
	private final int ADW = 1;
	/**
	 * The Constant to show the AlertDialog With elements
	 */
	private final int ADWCB = 2;
	/**
	 * The Constant to show the custom Alert Dialog without Title
	 */
	private final int CD = 3;
	/**
	 * The Constant to show the custom Alert Dialog with Title
	 */
	private final int CAD = 4;
	/**
	 * The Constant to show the ProgressAlert Dialog
	 */
	private final int PD = 5;
	/**
	 * The Constant to show the ProgressAlert Dialog Indetreminate
	 */
	private final int PDI = 6;

	/******************************************************************************************/
	/** Constructors **************************************************************************/
	/******************************************************************************************/

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// Instantiate the view
		setContentView(R.layout.main);
		// Instantiate the Button
		btnShowAD = (Button) findViewById(R.id.btnShowAlertDialog);
		btnShowADW = (Button) findViewById(R.id.btnShowAlertDialogWith);
		btnShowADWCB = (Button) findViewById(R.id.btnShowAlertDialogWithCB);
		btnShowCD = (Button) findViewById(R.id.btnShowCustomAlertDialogTitleless);
		btnShowCAD = (Button) findViewById(R.id.btnShowCustomAlertDialogWithTitle);
		btnShowPD = (Button) findViewById(R.id.btnShowProgressBar);
		btnShowPDI = (Button) findViewById(R.id.btnShowProgressBarIndeterminate);
		btnToast = (Button) findViewById(R.id.btnShowToast);
		// Add the listeners for the Buttons that display Dialog
		btnShowAD.setOnClickListener(new BtnshowDialogClickListener(AD));
		btnShowADW.setOnClickListener(new BtnshowDialogClickListener(ADW));
		btnShowADWCB.setOnClickListener(new BtnshowDialogClickListener(ADWCB));
		btnShowCD.setOnClickListener(new BtnshowDialogClickListener(CD));
		btnShowCAD.setOnClickListener(new BtnshowDialogClickListener(CAD));
		btnShowPD.setOnClickListener(new BtnshowDialogClickListener(PD));
		btnShowPDI.setOnClickListener(new BtnshowDialogClickListener(PDI));
		// Add the listener for the button that displays the Toast
		btnToast.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				showCustomToast();
			}
		});
	}

	/******************************************************************************************/
	/** The Main Method when displaying Dialog **************************************************************************/
	/******************************************************************************************/

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreateDialog(int)
	 */
	@Override
	protected Dialog onCreateDialog(int id) {
		Dialog dialog;
		switch (id) {
		case AD:
			dialog = buildAlertdDialog();
			break;
		case ADW:
			dialog = buildAlertDialogWithItems();
			break;
		case ADWCB:
			dialog = buildAlertDialogWithCheckBox();
			break;
		case CD:
			dialog = buildCustomDialog();
			break;
		case CAD:
			dialog = buildCustomAlertDialog();
			break;
		case PD:
			dialog = buildProgressBar();
			break;
		case PDI:
			dialog = buildProgressBarInde();
			break;
		default:
			dialog = null;
		}
		return dialog;
	}

	/******************************************************************************************/
	/** Build a simple AlertDialog **************************************************************************/
	/******************************************************************************************/

	/**
	 * @return a simple AlertDialog
	 */
	private Dialog buildAlertdDialog() {
		// Creation of the AlertDialog Builder
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		// a message
		builder.setMessage(getString(R.string.dialog_message));
		// a title
		builder.setTitle("Title");
		// No cancel button
		builder.setCancelable(false);
		// Define the OK button, it's message and its listener
		builder.setPositiveButton(getString(R.string.dialog_yes), new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				dialogOK(AD);
			}
		});
		// Define the KO button, it's message and its listener
		builder.setNegativeButton(getString(R.string.dialog_no), new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				dialogNOK(AD);
			}
		});
		// Then create the Dialog
		return builder.create();
	}

	/******************************************************************************************/
	/** Build an AlertDialog with Elements **************************************************************************/
	/******************************************************************************************/

	/**
	 * @return an AlertDialog with an item to select in a list
	 */
	private Dialog buildAlertDialogWithItems() {
		// The items declaration
		final CharSequence[] items = getResources().getTextArray(R.array.items);
		// create a builder
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		// Yes a cancel button please
		builder.setCancelable(true);
		// Cancel button definition (name and listener)
		builder.setNeutralButton(getString(R.string.dialog_cancel), new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				dialogCanceled(ADW);
			}
		});
		// No need to add Yes and No button, they'll be displayed but useless
		// because when an item is selected, the dialog is dismissed
		// Define the title
		builder.setTitle(getString(R.string.dialog_Title));
		// Affect the title to the Dialog and the listener
		builder.setItems(items, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int item) {
				dialogSelectItem(item, items[item].toString(), ADW);
			}
		});

		return builder.create();
	}

	/**
	 * There is a Problem in this method when rotating the application. The dialog still point to
	 * the old booleans array
	 * 
	 * @return an AlertDialog with a set of items to select in a list
	 */
	private Dialog buildAlertDialogWithCheckBox() {
		// The Items of the CheckBoxes
		final CharSequence[] items = getResources().getTextArray(R.array.items);
		// As usual the builder
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		// No cancel button
		builder.setCancelable(false);
		// Definition of the OK button (displayed text and listener)
		builder.setPositiveButton(getString(R.string.dialog_yes), new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				dialogOK(ADWCB);
			}
		});
		// Definition of the OK button (displayed text and listener)
		builder.setNegativeButton(getString(R.string.dialog_no), new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				dialogNOK(ADWCB);
			}
		});
		// Definition of the title
		builder.setTitle(getString(R.string.dialog_Title));
		// Using a single choice
		// builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
		// public void onClick(DialogInterface dialog, int item) {
		// Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
		// }
		// });
		// Definition of the MultiChoice : Using the items to display, the boolean array to store
		// the state of the checkBoxes and the listener
		builder.setMultiChoiceItems(items, checkedItems, new OnMultiChoiceClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which, boolean isChecked) {
				// checkedItems[which] = isChecked;
				checkBoxStateChanges(which, isChecked);
			}
		});
		// probleme de l'ecran retourné qui conserve l'etat du composant mais pointe vers un
		// autre
		// tableau de boolean

		return builder.create();
	}

	/**
	 * Method called when a CheckBox of the Dialog displaying checkBoxes is checked
	 * 
	 * @param which
	 * @param isChecked
	 */
	private void checkBoxStateChanges(int which, boolean isChecked) {
		// Just update the booleans array
		checkedItems[which] = isChecked;
	}

	/******************************************************************************************/
	/** Build an Customs Dialog **************************************************************************/
	/******************************************************************************************/

	/**
	 * Build a Custom Dialog
	 * 
	 * @return a custom dialog
	 */
	private Dialog buildCustomDialog() {
		// if the dialog is null, create it
		if (customDialog == null) {
			// create the dialog
			customDialog = new Dialog(this);
			// Build the Gui of the custom dialog using the setContentView, just like with Activity
			customDialog.setContentView(R.layout.custom_dialog_layout);
			// Define the dialog Title
			customDialog.setTitle(getString(R.string.CustomDialogTitle));
			// Retrieve the close button
			Button buttonClose = (Button) customDialog.findViewById(R.id.btnClose);
			// add a listener on it to close the dialog
			buttonClose.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					// Call the close custom dialog
					closeCustomDialog();
				}
			});
		}
		// return the dialog
		return customDialog;
	}

	/**
	 * Close The custom Dialog
	 */
	private void closeCustomDialog() {
		customDialog.dismiss();
	}

	/******************************************************************************************/
	/** Build an Customs AlertDialog **************************************************************************/
	/******************************************************************************************/

	/**
	 * Build a Custom AlertDialog
	 * 
	 * @return a custom dialog
	 */
	private Dialog buildCustomAlertDialog() {
		// As usual define the Builder
		AlertDialog.Builder builder;
		// Use the layout inflater method to build the layout
		LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
		// retrieve the Layout instance using the inflater
		View layout = inflater.inflate(R.layout.custom_dialog_layout, (ViewGroup) findViewById(R.id.layout_root));
		// instantiate the builder
		builder = new AlertDialog.Builder(this);
		// Retrieve the close button (using the layer)
		Button buttonClose = (Button) layout.findViewById(R.id.btnClose);
		// add a listener on it to close the dialog
		buttonClose.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// Call the close custom dialog
				dialogOK(CAD);
			}
		});
		builder.setView(layout);
		// Definition of the OK button (displayed text and listener)
		builder.setPositiveButton(getString(R.string.dialog_yes), new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int id) {
				dialogOK(CAD);
			}
		});
		// instantiate the alertDialog object
		return builder.create();
	}

	/******************************************************************************************/
	/** Build an AlertDialog with ProgressBar **************************************************************************/
	/******************************************************************************************/

	/**
	 * @return a ProgressDialog
	 */
	private Dialog buildProgressBar() {
		// Define the progressBar
		ProgressDialog progressDialog;
		// instanciate it
		progressDialog = new ProgressDialog(this);
		// define it style and its title and its message
		progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		progressDialog.setTitle(getString(R.string.progressDialogTitle));
		progressDialog.setMessage(getString(R.string.Loading));
		// can be killed by the user using the back touch
		// Else you need to close it when the threatment is finished
		progressDialog.setCancelable(true);
		// then you can manage the progress bar using:
		progressDialog.incrementProgressBy(1);
		progressDialog.setProgress(51);// Does not work... why?o?
		progressDialog.setMax(150);
		// but in fact you should use an Handler or an AsyncTask to do that
		return progressDialog;
	}

	/**
	 * @return a ProgressDialog indeterminate 
	 */
	private Dialog buildProgressBarInde() {
		// Define the progressBar
		ProgressDialog progressDialog;
		// instanciate it
		progressDialog = new ProgressDialog(this);
		// define it style and its title and message
		progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
		progressDialog.setTitle(getString(R.string.progressDialogTitle));
		progressDialog.setMessage(getString(R.string.Loading));
		//You can change the icon if you want
		progressDialog.setIcon(getResources().getDrawable(R.drawable.ic_launcher));
		// can be killed by the user using the back touch
		// Else you need to close it when the treatment is finished
		progressDialog.setCancelable(true);
		// then you can manage the progress bar using:
		progressDialog.setIndeterminate(true);
		// but in fact you should use an Handler or an AsyncTask to do that
		return progressDialog;
	}

	/******************************************************************************************/
	/** Methods Called when Dialog exits **************************************************************************/
	/******************************************************************************************/

	/**
	 * Method called when the dialog exits with the Cancel button
	 * 
	 * @param constant
	 *            the identifier of the Dialog
	 */
	private void dialogCanceled(int constant) {
		switch (constant) {
		case ADW:
		case CD:
		case CAD:
		case PD:
		default:
		}
		dismiss(constant);
	}

	/**
	 * Method called when the dialog exits with the OK button
	 * 
	 * @param constant
	 *            the identifier of the Dialog
	 */
	private void dialogOK(int constant) {

		switch (constant) {
		case AD:
			Toast.makeText(this, "Dialog Ok", Toast.LENGTH_SHORT).show();
			break;
		case ADWCB:
			Toast.makeText(
					this,
					"Dialog Ok and selected items are " + checkedItems[0] + "," + checkedItems[1] + ","
							+ checkedItems[2] + "," + checkedItems[3] + ",", Toast.LENGTH_SHORT).show();
			break;
		case CAD:
			Toast.makeText(this, "Custom Dialog Ok", Toast.LENGTH_SHORT).show();
			break;
		case CD:
		case PD:
			break;
		default:
		}
		dismiss(constant);
	}

	/**
	 * Method called when the dialog exits with the NOK button
	 * 
	 * @param constant
	 *            the identifier of the Dialog
	 */
	private void dialogNOK(int constant) {

		switch (constant) {
		case AD:
			Toast.makeText(this, "Dialog NOk", Toast.LENGTH_SHORT).show();
			break;
		case ADWCB:
			Toast.makeText(
					this,
					"Dialog Ok and selected items are " + checkedItems[0] + "," + checkedItems[1] + ","
							+ checkedItems[2] + "," + checkedItems[3] + ",", Toast.LENGTH_SHORT).show();
			break;
		case CD:
		case CAD:
		case PD:
		default:
		}
		dismiss(constant);
	}

	/**
	 * @param itemNumber
	 * @param itemValues
	 * @param constant
	 */
	private void dialogSelectItem(int itemNumber, String itemValues, int constant) {
		Toast.makeText(this, "Dialog Selected Item " + itemNumber + " :" + itemValues, Toast.LENGTH_SHORT).show();
		dismiss(constant);
	}

	/**
	 * @param constant
	 */
	private void dismiss(int constant) {
		dismissDialog(constant);
	}

	/******************************************************************************************/
	/** Toast Management **************************************************************************/
	/******************************************************************************************/

	/**
	 * Show a Custom Toast to the user
	 */
	private void showCustomToast() {
		// Call the Layout Inflater to build the View object from an Xml description
		LayoutInflater inflater = getLayoutInflater();
		// Build the view using the file R.layout.toast_layout using the R.id.toast_layout_root
		// element as the root view
		View layout = inflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_layout_root));

		// This work too and duplicate the view in the Toast
		// View layout = inflater.inflate(R.layout.main,null);

		// then create the Toast
		Toast toast = new Toast(this);
		// Define the gravity can be all the gravity constant and can be associated using |
		// (exemple: Gravity.TOP|Gravity.LEFT)
		// the xOffset and yOffSet moves the Toast (in pixel)
		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		// define the time duration of the Toast
		toast.setDuration(Toast.LENGTH_LONG);
		// Set the layout of the toast
		toast.setView(layout);
		// And display it
		toast.show();
	}

	/******************************************************************************************/
	/** The Inner class to add listener in a clean way **************************************************************************/
	/******************************************************************************************/
	/**
	 * @author Mathias Seguy (Android2EE)
	 * @goals
	 *        This class aims to simplify adding listeners to the button (it's a cosmetic inner
	 *        class)
	 */
	private class BtnshowDialogClickListener implements View.OnClickListener {
		/**
		 * The id of the Dialog to display
		 */
		Integer dialogCst;

		/**
		 * The specific contsructor to use with dialog constant
		 * 
		 * @param dialogConstant
		 */
		public BtnshowDialogClickListener(Integer dialogConstant) {
			dialogCst = dialogConstant;
		}

		@Override
		public void onClick(View v) {
			showDialog(dialogCst);
		}
	}

	/******************************************************************************************/
	/** Managing LifeCycle (to be sure opening a dialog doesn't change the activity state ******/
	/******************************************************************************************/

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onDestroy()
	 */
	@Override
	protected void onDestroy() {
		Log.w(tag, "onDestroy called");
		// remove all the dialog
		removeDialog(AD);
		removeDialog(ADW);
		removeDialog(ADWCB);
		removeDialog(CD);
		removeDialog(CAD);
		removeDialog(PD);
		removeDialog(PDI);
		super.onDestroy();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onPause()
	 */
	@Override
	protected void onPause() {
		Log.w(tag, "onPause called");
		super.onPause();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onRestart()
	 */
	@Override
	protected void onRestart() {
		Log.w(tag, "onRestart called");
		super.onRestart();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {
		Log.w(tag, "onResume called");
		super.onResume();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onStart()
	 */
	@Override
	protected void onStart() {
		Log.w(tag, "onStart called");
		super.onStart();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onStop()
	 */
	@Override
	protected void onStop() {
		Log.w(tag, "onStop called");
		super.onStop();
	}
}