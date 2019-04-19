package jmri.jmrit.ctc.editor.gui;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import jmri.jmrit.ctc.editor.code.AwtWindowProperties;
import jmri.jmrit.ctc.editor.code.CommonSubs;
import jmri.jmrit.ctc.editor.code.FindAndReplace;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import jmri.jmrit.ctc.ctcserialdata.CTCSerialData;
import jmri.jmrit.ctc.ctcserialdata.CodeButtonHandlerData;
import jmri.jmrit.ctc.ctcserialdata.ProjectsCommonSubs;

/**
 *
 * @author Gregory J. Bedlek Copyright (C) 2018, 2019
 */
public class FrmFindAndReplace extends javax.swing.JFrame {

    /**
     * Creates new form DlgFindAndReplace
     */
    private static final String FORM_PROPERTIES = "DlgFindAndReplace";  // NOI18N
    private final AwtWindowProperties _mAwtWindowProperties;
    private final CTCSerialData _mCTCSerialData;
    private final DefaultTableModel _mDefaultTableModel;
    private String _mSearchForTextFrozen = "";

    private ArrayList<FindAndReplace.SearchResults> _mSearchResults = null;

    public FrmFindAndReplace(AwtWindowProperties awtWindowProperties, CTCSerialData ctcSerialData) {
        super();
        initComponents();
        CommonSubs.addHelpMenu(this, "package.jmri.jmrit.ctc.CTC_menuEditFind", true);  // NOI18N
        _mAwtWindowProperties = awtWindowProperties;
        _mCTCSerialData = ctcSerialData;
        _mDefaultTableModel = (DefaultTableModel)_mResults.getModel();  // We know this is the type by default construction!
        _mContains.setSelected(true);
        _mSearchForText.requestFocusInWindow();
        _mAwtWindowProperties.setWindowState(this, FORM_PROPERTIES);
        TableColumnModel tableColumnModel = _mResults.getColumnModel();
        _mResults.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);    // Otherwise these don't work:
        tableColumnModel.getColumn(0).setPreferredWidth(60);
        tableColumnModel.getColumn(1).setPreferredWidth(320);
        tableColumnModel.getColumn(2).setPreferredWidth(600);
        _mReplaceCompletely.setSelected(true);          // Defaults:
        this.getRootPane().setDefaultButton(_mSearch);
        _mSelectDeselectAll.setText(Bundle.getMessage("InfoDlgFindSelectAll")); // NOI18N
        CommonSubs.numberButtonGroup(_mHowReplace);
        CommonSubs.setButtonSelected(_mHowReplace, 1);

        _mResults.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
           public void valueChanged(ListSelectionEvent event)  {
               if (!event.getValueIsAdjusting()) {
                   updateSelectionCount();
               }
           }
        });
    }

    private void updateSelectionCount() {
        int selectionCount = _mResults.getSelectedRows().length;
        _mCountSelected.setText(Bundle.getMessage("InfoDlgFindCount") + " " + Integer.toString(selectionCount));    // NOI18N
        _mReplace.setEnabled(selectionCount > 0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")  // NOI18N
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        _mHowSearch = new javax.swing.ButtonGroup();
        _mHowReplace = new javax.swing.ButtonGroup();
        _mButtonDone = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        _mCaseSensitive = new javax.swing.JCheckBox();
        _mSearchForText = new javax.swing.JTextField();
        _mSearch = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        _mExactWholeMatch = new javax.swing.JRadioButton();
        _mContains = new javax.swing.JRadioButton();
        _mReplaceCompletely = new javax.swing.JRadioButton();
        _mReplaceSearched = new javax.swing.JRadioButton();
        _mRescanAndReplaceWith = new javax.swing.JRadioButton();
        _mReplaceWith = new javax.swing.JTextField();
        _mRescanWithValue = new javax.swing.JTextField();
        _mReplace = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        _mResults = new javax.swing.JTable();
        _mSelectDeselectAll = new javax.swing.JButton();
        _mCountSelected = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle(Bundle.getMessage("TitleDlgFind"));
        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        _mButtonDone.setText(Bundle.getMessage("ButtonDone"));
        _mButtonDone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _mButtonDoneActionPerformed(evt);
            }
        });

        jLabel1.setText(Bundle.getMessage("InfoDlgFindNote"));

        jLabel3.setText(Bundle.getMessage("LabelDlgFindSearch"));

        _mCaseSensitive.setText(Bundle.getMessage("LabelDlgFindCase"));

        _mSearch.setText(Bundle.getMessage("ButtonDlgFindSearch"));
        _mSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _mSearchActionPerformed(evt);
            }
        });

        jLabel4.setText(Bundle.getMessage("InfoDlgFindResults"));

        _mHowSearch.add(_mExactWholeMatch);
        _mExactWholeMatch.setText(Bundle.getMessage("LabelDlgFindExact"));

        _mHowSearch.add(_mContains);
        _mContains.setText(Bundle.getMessage("LabelDlgFindContains"));

        _mHowReplace.add(_mReplaceCompletely);
        _mReplaceCompletely.setText(Bundle.getMessage("LabelDlgFindComplete"));

        _mHowReplace.add(_mReplaceSearched);
        _mReplaceSearched.setText(Bundle.getMessage("LabelDlgFindSearched"));

        _mHowReplace.add(_mRescanAndReplaceWith);
        _mRescanAndReplaceWith.setText(Bundle.getMessage("LabelDlgFindRescan"));

        _mReplace.setText(Bundle.getMessage("ButtonDlgFindReplace"));
        _mReplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _mReplaceActionPerformed(evt);
            }
        });

        jLabel8.setText(Bundle.getMessage("LabelDlgFindReplace"));

        _mResults.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Sw/Sig:", "Field name:", "Contents found:"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            @Override
            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        _mResults.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        jScrollPane1.setViewportView(_mResults);

        _mSelectDeselectAll.setText("?Select all");
        _mSelectDeselectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                _mSelectDeselectAllActionPerformed(evt);
            }
        });

        _mCountSelected.setText(Bundle.getMessage("LabelDlgFindCount"));

        jLabel6.setText(Bundle.getMessage("InfoDlgFindOnly"));

        jLabel7.setText(Bundle.getMessage("InfoDlgFindUndo"));

        jLabel2.setText(Bundle.getMessage("InfoDlgFindChange"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(_mSearchForText, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(_mCaseSensitive)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(_mContains)
                                        .addComponent(_mExactWholeMatch)))
                                .addComponent(_mReplaceCompletely)
                                .addComponent(_mReplaceSearched)
                                .addComponent(_mRescanAndReplaceWith))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(_mReplaceWith, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(_mSearch)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(_mReplace)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(_mCountSelected))
                                    .addComponent(_mRescanWithValue, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(_mButtonDone))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(_mSelectDeselectAll)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1097, Short.MAX_VALUE)))
                    .addComponent(jLabel1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(_mSearchForText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_mCaseSensitive)
                    .addComponent(_mExactWholeMatch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_mContains)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_mSearch)
                .addGap(34, 34, 34)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_mReplaceWith, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(_mReplaceCompletely)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_mReplaceSearched)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_mRescanAndReplaceWith)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(_mRescanWithValue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_mReplace)
                    .addComponent(_mCountSelected))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(_mButtonDone)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(_mSelectDeselectAll)
                    .addComponent(jLabel4)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void _mSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__mSearchActionPerformed
        _mSearchResults = FindAndReplace.doSearch(_mCTCSerialData, _mSearchForText.getText(), _mCaseSensitive.isSelected(), _mExactWholeMatch.isSelected());
        _mSearchForTextFrozen = _mSearchForText.getText();    // Freeze it so that user doesn't change it between the time they pushed this button and the time they press the replace button!
//  Once you specify a model, then functions like JList.setListData may update the screen, but the model
//  DOES NOT SEE ANY OF THE DATA!  Therefore, I have to load the data via the model instead of directly:
        _mDefaultTableModel.setRowCount(0);  //.clear(); // Superflous but doesn't hurt in case GUI designer put something in there.....
        for (FindAndReplace.SearchResults searchResult : _mSearchResults) {
            _mDefaultTableModel.addRow(new Object[]{ searchResult._mUserSwitchSignalEtcEntry, searchResult._mUserFieldName, searchResult._mUserContent });
        }
        boolean anyFound = _mDefaultTableModel.getRowCount() == 0 ? false : true;
        _mReplaceWith.setEnabled(anyFound);
        _mReplaceCompletely.setEnabled(anyFound);
        _mReplaceSearched.setEnabled(anyFound);
        _mRescanAndReplaceWith.setEnabled(anyFound);
        _mRescanWithValue.setEnabled(anyFound);
        _mReplace.setEnabled(false);                // By default, we DON'T select any at start!
        _mSelectDeselectAll.setEnabled(anyFound);
        _mCountSelected.setVisible(anyFound);
        updateSelectionCount();
    }//GEN-LAST:event__mSearchActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        _mAwtWindowProperties.saveWindowState(this, FORM_PROPERTIES);
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void _mSelectDeselectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__mSelectDeselectAllActionPerformed
        if (_mSelectDeselectAll.getText().equals(Bundle.getMessage("InfoDlgFindSelectAll"))) {  // NOI18N
            if (_mResults.getRowCount() > 0) {
                _mResults.setRowSelectionInterval(0, _mResults.getRowCount() - 1);
            }
            _mSelectDeselectAll.setText(Bundle.getMessage("InfoDlgFindDeselectAll"));   // NOI18N
        } else {
            _mResults.clearSelection();
            _mSelectDeselectAll.setText(Bundle.getMessage("InfoDlgFindSelectAll")); // NOI18N
        }
    }//GEN-LAST:event__mSelectDeselectAllActionPerformed

    @SuppressFBWarnings(value = "DE_MIGHT_IGNORE", justification = "See comment on the line.")
    private void _mReplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__mReplaceActionPerformed
//  First thing, prune entries based upon selection:
        int[] selectedRows = _mResults.getSelectedRows();
        ArrayList<FindAndReplace.SearchResults> selectedSearchResults = new ArrayList<>();
        for (int selectedRow : selectedRows) {
            selectedSearchResults.add(_mSearchResults.get(selectedRow));
        }
//  Perform the action the user requested:
        switch (ProjectsCommonSubs.getButtonSelectedInt(_mHowReplace)) {
            case 0:     // Replace completely:
                for (FindAndReplace.SearchResults selectedSearchResult : selectedSearchResults) {
                    int index = selectedSearchResult._mIndexIntoCodeButtonHandlerDataList;
                    CodeButtonHandlerData temp = _mCTCSerialData.getCodeButtonHandlerData(index);
                    try {
                        String textToReplaceWith = _mReplaceWith.getText();
                        selectedSearchResult._mField.set(temp, textToReplaceWith);
                        _mDefaultTableModel.setValueAt(textToReplaceWith, selectedSearchResult._mUserTableLine, 2);
                    } catch (IllegalAccessException e) {}   // CAN'T happen, since we ALREADY fetched it's contents previously the same way!
                }
                break;
            case 1:     // Replace searched for value only:
                for (FindAndReplace.SearchResults selectedSearchResult : selectedSearchResults) {
                    int index = selectedSearchResult._mIndexIntoCodeButtonHandlerDataList;
                    CodeButtonHandlerData temp = _mCTCSerialData.getCodeButtonHandlerData(index);
                    try {
                        String textToReplaceWith = ((String)selectedSearchResult._mField.get(temp)).replaceFirst(_mSearchForTextFrozen, _mReplaceWith.getText());
                        selectedSearchResult._mField.set(temp, textToReplaceWith);
                        _mDefaultTableModel.setValueAt(textToReplaceWith, selectedSearchResult._mUserTableLine, 2);
                    } catch (IllegalAccessException e) {}   // CAN'T happen, since we ALREADY fetched it's contents previously the same way!
                }
                break;
            case 2:
                for (FindAndReplace.SearchResults selectedSearchResult : selectedSearchResults) {
                    int index = selectedSearchResult._mIndexIntoCodeButtonHandlerDataList;
                    CodeButtonHandlerData temp = _mCTCSerialData.getCodeButtonHandlerData(index);
                    try {
                        String textToReplaceWith = ((String)selectedSearchResult._mField.get(temp)).replaceFirst(_mRescanWithValue.getText(), _mReplaceWith.getText());
                        selectedSearchResult._mField.set(temp, textToReplaceWith);
                        _mDefaultTableModel.setValueAt(textToReplaceWith, selectedSearchResult._mUserTableLine, 2);
                    } catch (IllegalAccessException e) {}   // CAN'T happen, since we ALREADY fetched it's contents previously the same way!
                }
                break;
            default:
                break;
        }
    }//GEN-LAST:event__mReplaceActionPerformed

    private void _mButtonDoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event__mButtonDoneActionPerformed
       _mAwtWindowProperties.saveWindowState(this, FORM_PROPERTIES);
        dispose();
     }//GEN-LAST:event__mButtonDoneActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton _mButtonDone;
    private javax.swing.JCheckBox _mCaseSensitive;
    private javax.swing.JRadioButton _mContains;
    private javax.swing.JLabel _mCountSelected;
    private javax.swing.JRadioButton _mExactWholeMatch;
    private javax.swing.ButtonGroup _mHowReplace;
    private javax.swing.ButtonGroup _mHowSearch;
    private javax.swing.JButton _mReplace;
    private javax.swing.JRadioButton _mReplaceCompletely;
    private javax.swing.JRadioButton _mReplaceSearched;
    private javax.swing.JTextField _mReplaceWith;
    private javax.swing.JRadioButton _mRescanAndReplaceWith;
    private javax.swing.JTextField _mRescanWithValue;
    private javax.swing.JTable _mResults;
    private javax.swing.JButton _mSearch;
    private javax.swing.JTextField _mSearchForText;
    private javax.swing.JButton _mSelectDeselectAll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
