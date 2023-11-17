/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package App;


import oshi.SystemInfo;
import oshi.hardware.CentralProcessor;
import oshi.hardware.ComputerSystem;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.software.os.OperatingSystem;
/**
 *
 * @author Yestin
 */
public class ComputerIdentifier {
    
    public static String getGenereteKey(){
        SystemInfo SystemInfo = new SystemInfo();
//        OperatingSystem OS = SystemInfo.getOperatingSystem();
        HardwareAbstractionLayer HAL = SystemInfo.getHardware();
////        CentralProcessor CentralProcessor = HAL.getProcessor();
        ComputerSystem ComputerSystem = HAL.getComputerSystem();
        
//        String Vendor = OS.getManufacturer();
        String ProcessorSN = ComputerSystem.getSerialNumber();
//        String PrcessorIdentifier = CentralProcessor.getProcessorIdentifier().getIdentifier();
//        int Processor = CentralProcessor.getLogicalProcessorCount();
        String Vendor = ComputerSystem.getManufacturer();
        String HardwareUUID = ComputerSystem.getHardwareUUID();
        String Model = ComputerSystem.getModel();
        
        return "ProcessorSN : "+ProcessorSN+",\nVendor : "+Vendor+",\nHardwareUUID : "+HardwareUUID+"\nModel : "+Model;
    }
    
    
//    public static void main(String Args[]){
//        String GenereteKey = getGenereteKey();
//        System.err.println(GenereteKey);
//    }
}
