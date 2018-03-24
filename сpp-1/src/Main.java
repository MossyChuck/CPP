
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.*;

public class Main {

    public static void main(String[] args) {
        new Main().build();
    }

    Label label1;
    Label answerLabel;
    Text textField;


    public void build() {
        Display display = new Display();

        Shell mainShell = new Shell(display);
        // the layout manager handle the layout
        // of the widgets in the container
        GridLayout layout = new GridLayout();
        layout.numColumns = 2;
        mainShell.setLayout(layout);
        Composite composite = new Composite(mainShell, SWT.LEFT);
        composite.setLayout(new RowLayout());

        // Shell can be used as container
        label1 = new Label(composite, SWT.PUSH);
        label1.setText("Год ");
        textField = new Text(composite, SWT.BORDER);
        Label label2 = new Label(mainShell, SWT.PUSH);
        label2.setText("Количество дней: 365");
        Composite buttonComposite = new Composite(mainShell, SWT.LEFT);
        buttonComposite.setLayout(new GridLayout());
        GridData gdButton = new GridData(GridData.FILL_BOTH);
        gdButton.widthHint = 100;
        Button button = new Button(buttonComposite, SWT.PUSH);
        button.setLayoutData(gdButton);
        button.setText("Проверить");
        button.setSize(1000, 10);
        Composite answerLabelComposite = new Composite(mainShell, SWT.LEFT);
        answerLabelComposite.setLayout(new GridLayout());
        GridData gdAnswerLabel = new GridData(GridData.FILL_BOTH);
        gdAnswerLabel.widthHint = 100;
        answerLabel = new Label(answerLabelComposite, SWT.PUSH);
        answerLabel.setText("Високосный: ?");
        answerLabel.setLayoutData(gdAnswerLabel);


        //register listener for the selection event
        button.addSelectionListener(new ButtonSelectionListener());

        // set widgets size to their preferred size
        mainShell.pack();
        mainShell.open();
        while (!mainShell.isDisposed()) {
            if (!display.readAndDispatch()) {
                display.sleep();
            }
        }
        display.dispose();
    }


    class ButtonSelectionListener implements SelectionListener {

        @Override
        public void widgetSelected(SelectionEvent e) {
            // TODO Auto-generated method stub
            try {
                int year = Integer.parseInt(textField.getText());

                if ((year % 400 == 0) || (year % 100 != 0 && year % 4 == 0)) {
                    answerLabel.setText("Високосный: да");
                } else {
                    answerLabel.setText("Високосный: нет");
                }

            } catch (NumberFormatException exception) {
                answerLabel.setText("Високосный: ?");
            }

        }

        @Override
        public void widgetDefaultSelected(SelectionEvent e) {
            // TODO Auto-generated method stub

        }

    }
}