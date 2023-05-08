import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class MainForm extends JFrame {
    private JPanel mainWindow;
    private JButton prev;
    private JButton next;
    private JLabel name;
    private JLabel date;
    private JLabel credits;

    private ArrayList<Navstevnik> aktNav = new ArrayList<>();
    private int currIndex = 0;

    private JMenu menu;
    private JMenuBar menuBar;
    private JMenuItem pocetNav;
    private JMenuItem kreditCelk;
    private JMenuItem uloz;

    public MainForm() {
        addNav();

        menuBar = new JMenuBar();

        menu = new JMenu("Soubor");

        pocetNav = new JMenuItem("Počet návštěvníků");
        kreditCelk = new JMenuItem("Kredity celkemu");
        uloz = new JMenuItem("Uloz seznam");


        menu.add(pocetNav);
        menu.add(kreditCelk);
        menu.add(uloz);

        menuBar.add(menu);
        setJMenuBar(menuBar);

        //volam 1 pro jeden vybrany objekt pro ziskani dat
        Navstevnik random = getRandomNav();

        name.setText(random.getJmeno()+" "+random.getPrijmeni());
        date.setText(random.getDatumNavstevy().toString());
        credits.setText(String.valueOf(random.getPocetKreditu()));


        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currIndex++;
                System.out.println(currIndex);
                if(currIndex < aktNav.size()) {
                    fillData(aktNav.get(currIndex));
                }else {
                    fillData(aktNav.get(0));
                    currIndex = 0;
                }

            }
        });
        prev.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currIndex--;
                if(currIndex >= 0) {
                    fillData(aktNav.get(currIndex));
                }else if(currIndex < 0) {
                    currIndex = 0;
                }
            }
        });
        uloz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    //nastaveni statickeho parametru oddelovac na pozadovanou hodnotu #
                    Soubor.ODDELOVAC = "#";
                    JFileChooser jfw = new JFileChooser();
                    jfw.setDialogTitle("Vyber soubor");
                    int res = jfw.showDialog(mainWindow, "Vyber");
                    if(res == JFileChooser.CANCEL_OPTION) {
                        JOptionPane.showMessageDialog(mainWindow,"Nebyl vybran zadny soubor","Warn", JOptionPane.WARNING_MESSAGE);
                    }else if (res == JFileChooser.APPROVE_OPTION) {
                        Soubor.uloz(jfw.getSelectedFile(), aktNav);
                        JOptionPane.showMessageDialog(mainWindow,"Uloženo", "Info", JOptionPane.INFORMATION_MESSAGE);
                    }else {
                        JOptionPane.showMessageDialog(mainWindow,"Chyba","Error", JOptionPane.ERROR_MESSAGE);
                    }
                }catch(IOException ex) {
                    JOptionPane.showMessageDialog(mainWindow,ex.getMessage(),"Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        pocetNav.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainWindow,"V seznamu je "+aktNav.size() + " návštěvníků", "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        kreditCelk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(mainWindow,"Celkový počet kreditů je "+kreditCelk(), "Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    private int kreditCelk() {
        int kredit = 0;
        for(Navstevnik n : aktNav) {
            kredit += n.getPocetKreditu();
        }
        return kredit;
    }

    private void fillData(Navstevnik n) {
        name.setText(n.getJmeno()+" "+n.getPrijmeni());
        date.setText(n.getDatumNavstevy().toString());
        credits.setText(String.valueOf(n.getPocetKreditu()));
    }

    private void addNav() {
        Navstevnik n1 = new Navstevnik("John", "Doe", LocalDate.now(),20); //0
        Navstevnik n2 = new Navstevnik("Jane", "Doe", LocalDate.now(),30); //1
        aktNav.add(n1);
        aktNav.add(n2);
    }

    private Navstevnik getRandomNav() {
        int index = Numbers.random(0,aktNav.size());
        currIndex = index;

        System.out.println(currIndex);
        return aktNav.get(index);
    }

    public JPanel getMainWindow() {
        return mainWindow;
    }

    public ArrayList<Navstevnik> getAktNav() {
        return aktNav;
    }
}
