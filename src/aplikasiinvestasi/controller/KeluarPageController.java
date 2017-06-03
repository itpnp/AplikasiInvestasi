/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package aplikasiinvestasi.controller;

import aplikasiinvestasi.service.KeluarService;
import aplikasiinvestasi.service.impl.KeluarServiceImpl;
import aplikasiinvestasi.view.KeluarBskkPage;

/**
 *
 * @author Rizaldi Habibie
 */
public class KeluarPageController {
    KeluarBskkPage keluarPage = new KeluarBskkPage();
    KeluarService keluarService = new KeluarServiceImpl();
}
