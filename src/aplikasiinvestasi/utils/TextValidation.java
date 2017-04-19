/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.utils;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Rizaldi Habibie
 */
public class TextValidation extends PlainDocument{
    
    public TextValidation(){
        super();
    }
    
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException{
      char[] array = str.toCharArray();
      boolean valid = false;
      
      for(char c : array){
          if(Character.isDigit(c)){
              valid = true;
          }else{
              valid = false;
              break;
          }
      }
      if(valid){
          super.insertString(offs, str, a);
      }else{
          //blocking
      }
    }
}
