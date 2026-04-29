package com.neptune.cbawrapper.Services;

import com.neptune.cbawrapper.Models.Bank;
import com.neptune.cbawrapper.Models.Lgas;
import com.neptune.cbawrapper.Models.States;
import com.neptune.cbawrapper.Repository.BankRepository;
import com.neptune.cbawrapper.Repository.LgaRepository;
import com.neptune.cbawrapper.Repository.StateRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SeederService implements CommandLineRunner {

    private final BankRepository bankRepository;
    private final StateRepository stateRepository;
    private final LgaRepository lgaRepository;

    public SeederService(BankRepository bankRepository, StateRepository stateRepository, LgaRepository lgaRepository) {
        this.bankRepository = bankRepository;
        this.stateRepository = stateRepository;
        this.lgaRepository = lgaRepository;
    }

    @Override
    public void run(String... args) {
        seedBanks();
        seedStates();
        seedLgas();
    }

    public void seedBanks() {

        // Prevent duplicate insert
        if (bankRepository.count() > 0) {
            return;
        }

        List<Bank> banks = new ArrayList<>();

        banks.add(Bank.builder().serialNumber(1).bankName("ACCESS BANK PLC").bankCode("044").build());
        banks.add(Bank.builder().serialNumber(2).bankName("CITI BANK").bankCode("023").build());
        banks.add(Bank.builder().serialNumber(3).bankName("DIAMOND BANK PLC").bankCode("063").build());
        banks.add(Bank.builder().serialNumber(4).bankName("ECOBANK NIGERIA PLC").bankCode("050").build());
        banks.add(Bank.builder().serialNumber(5).bankName("ENTERPRISE BANK PLC").bankCode("084").build());
        banks.add(Bank.builder().serialNumber(6).bankName("FIDELITY BANK PLC").bankCode("070").build());
        banks.add(Bank.builder().serialNumber(7).bankName("FIRST BANK OF NIGERIA").bankCode("011").build());
        banks.add(Bank.builder().serialNumber(8).bankName("FIRST CITY MONUMENT BANK").bankCode("214").build());
        banks.add(Bank.builder().serialNumber(9).bankName("GLOBUS BANK").bankCode("103").build());
        banks.add(Bank.builder().serialNumber(10).bankName("GUARANTY TRUST BANK PLC").bankCode("058").build());
        banks.add(Bank.builder().serialNumber(11).bankName("HERITAGE BANK").bankCode("030").build());
        banks.add(Bank.builder().serialNumber(12).bankName("JAIZ BANK").bankCode("301").build());
        banks.add(Bank.builder().serialNumber(13).bankName("KEYSTONE BANK PLC").bankCode("082").build());
        banks.add(Bank.builder().serialNumber(14).bankName("LOTUS BANK").bankCode("303").build());
        banks.add(Bank.builder().serialNumber(15).bankName("MAIN STREET BANK NIGERIA").bankCode("014").build());
        banks.add(Bank.builder().serialNumber(16).bankName("PARALEX BANK").bankCode("104").build());
        banks.add(Bank.builder().serialNumber(17).bankName("POLARIS BANK").bankCode("076").build());
        banks.add(Bank.builder().serialNumber(18).bankName("PROVIDUS BANK").bankCode("101").build());
        banks.add(Bank.builder().serialNumber(19).bankName("SKYE BANK PLC").bankCode("076").build());
        banks.add(Bank.builder().serialNumber(20).bankName("STANBIC IBTC BANK PLC").bankCode("221").build());
        banks.add(Bank.builder().serialNumber(21).bankName("STANDARD CHARTERED BANK PLC").bankCode("068").build());
        banks.add(Bank.builder().serialNumber(22).bankName("STERLING BANK PLC").bankCode("232").build());
        banks.add(Bank.builder().serialNumber(23).bankName("TAJ BANK").bankCode("302").build());
        banks.add(Bank.builder().serialNumber(26).bankName("Titantrust BANK").bankCode("102").build());
        banks.add(Bank.builder().serialNumber(27).bankName("UNION BANK OF NIGERIA").bankCode("032").build());
        banks.add(Bank.builder().serialNumber(28).bankName("UNITED BANK FOR AFRICA").bankCode("033").build());
        banks.add(Bank.builder().serialNumber(29).bankName("UNITY BANK PLC").bankCode("215").build());
        banks.add(Bank.builder().serialNumber(30).bankName("WEMA BANK PLC").bankCode("035").build());
        banks.add(Bank.builder().serialNumber(31).bankName("ZENITH INTERNATIONAL BANK PLC").bankCode("057").build());

        bankRepository.saveAll(banks);

        System.out.println("All banks seeded successfully.");
    }

    public void seedStates() {

        // Prevent duplicate inserts
        if (stateRepository.count() > 0) {
            return;
        }

        List<States> states = new ArrayList<>();

        states.add(States.builder().serialNumber(1).stateName("ABIA").stateCode("AB").build());
        states.add(States.builder().serialNumber(2).stateName("ADAMAWA").stateCode("AD").build());
        states.add(States.builder().serialNumber(3).stateName("AKWA IBOM").stateCode("AK").build());
        states.add(States.builder().serialNumber(4).stateName("ANAMBRA").stateCode("AN").build());
        states.add(States.builder().serialNumber(5).stateName("BAUCHI").stateCode("BA").build());
        states.add(States.builder().serialNumber(6).stateName("BAYELSA").stateCode("BY").build());
        states.add(States.builder().serialNumber(7).stateName("BENUE").stateCode("BE").build());
        states.add(States.builder().serialNumber(8).stateName("BORNO").stateCode("BO").build());
        states.add(States.builder().serialNumber(9).stateName("CROSS RIVER").stateCode("CR").build());
        states.add(States.builder().serialNumber(10).stateName("DELTA").stateCode("DE").build());
        states.add(States.builder().serialNumber(11).stateName("EBONYI").stateCode("EB").build());
        states.add(States.builder().serialNumber(12).stateName("EDO").stateCode("ED").build());
        states.add(States.builder().serialNumber(13).stateName("EKITI").stateCode("EK").build());
        states.add(States.builder().serialNumber(14).stateName("ENUGU").stateCode("EN").build());
        states.add(States.builder().serialNumber(15).stateName("ABUJA").stateCode("FC").build());
        states.add(States.builder().serialNumber(16).stateName("GOMBE").stateCode("GO").build());
        states.add(States.builder().serialNumber(17).stateName("IMO").stateCode("IM").build());
        states.add(States.builder().serialNumber(18).stateName("JIGAWA").stateCode("JI").build());
        states.add(States.builder().serialNumber(19).stateName("KADUNA").stateCode("KD").build());
        states.add(States.builder().serialNumber(20).stateName("KANO").stateCode("KN").build());
        states.add(States.builder().serialNumber(21).stateName("KATSINA").stateCode("KT").build());
        states.add(States.builder().serialNumber(22).stateName("KEBBI").stateCode("KE").build());
        states.add(States.builder().serialNumber(23).stateName("KOGI").stateCode("KO").build());
        states.add(States.builder().serialNumber(24).stateName("KWARA").stateCode("KW").build());
        states.add(States.builder().serialNumber(25).stateName("LAGOS").stateCode("LA").build());
        states.add(States.builder().serialNumber(26).stateName("NASARAWA").stateCode("NA").build());
        states.add(States.builder().serialNumber(27).stateName("NIGER").stateCode("NI").build());
        states.add(States.builder().serialNumber(28).stateName("OGUN").stateCode("OG").build());
        states.add(States.builder().serialNumber(29).stateName("ONDO").stateCode("ON").build());
        states.add(States.builder().serialNumber(30).stateName("OSUN").stateCode("OS").build());
        states.add(States.builder().serialNumber(31).stateName("OYO").stateCode("OY").build());
        states.add(States.builder().serialNumber(32).stateName("PLATEAU").stateCode("PL").build());
        states.add(States.builder().serialNumber(33).stateName("RIVER").stateCode("RI").build());
        states.add(States.builder().serialNumber(34).stateName("SOKOTO").stateCode("SO").build());
        states.add(States.builder().serialNumber(35).stateName("TARABA").stateCode("TA").build());
        states.add(States.builder().serialNumber(36).stateName("YOBE").stateCode("YO").build());
        states.add(States.builder().serialNumber(37).stateName("ZAMFARA").stateCode("ZA").build());

        stateRepository.saveAll(states);

        System.out.println("All states seeded successfully.");
    }

    public void seedLgas() {

        // Prevent duplicate inserts
        if (lgaRepository.count() > 0) {
            return;
        }

        List<Lgas> lgas = new ArrayList<>();

        lgas.add(Lgas.builder().lgaName("Epe").stateCode("LA").lgaCode("LA001").build());
        lgas.add(Lgas.builder().lgaName("Ibeju-Lekki").stateCode("LA").lgaCode("LA002").build());
        lgas.add(Lgas.builder().lgaName("Eti Osa").stateCode("LA").lgaCode("LA003").build());
        lgas.add(Lgas.builder().lgaName("Lagos Island").stateCode("LA").lgaCode("LA004").build());
        lgas.add(Lgas.builder().lgaName("Amuwo-Odofin").stateCode("LA").lgaCode("LA005").build());
        lgas.add(Lgas.builder().lgaName("Apapa").stateCode("LA").lgaCode("LA006").build());
        lgas.add(Lgas.builder().lgaName("Ajeromi-Ifelodun").stateCode("LA").lgaCode("LA007").build());
        lgas.add(Lgas.builder().lgaName("Badagry").stateCode("LA").lgaCode("LA008").build());
        lgas.add(Lgas.builder().lgaName("Ojo").stateCode("LA").lgaCode("LA009").build());
        lgas.add(Lgas.builder().lgaName("Oshodi-Isolo").stateCode("LA").lgaCode("LA010").build());
        lgas.add(Lgas.builder().lgaName("Alimosho").stateCode("LA").lgaCode("LA011").build());
        lgas.add(Lgas.builder().lgaName("Agege").stateCode("LA").lgaCode("LA012").build());
        lgas.add(Lgas.builder().lgaName("Ifako-Ijaiye").stateCode("LA").lgaCode("LA013").build());
        lgas.add(Lgas.builder().lgaName("Mushin").stateCode("LA").lgaCode("LA014").build());
        lgas.add(Lgas.builder().lgaName("Ikeja").stateCode("LA").lgaCode("LA015").build());
        lgas.add(Lgas.builder().lgaName("Surulere").stateCode("LA").lgaCode("LA016").build());
        lgas.add(Lgas.builder().lgaName("Shomolu").stateCode("LA").lgaCode("LA017").build());
        lgas.add(Lgas.builder().lgaName("Lagos Mainland").stateCode("LA").lgaCode("LA018").build());
        lgas.add(Lgas.builder().lgaName("Ikorodu").stateCode("LA").lgaCode("LA019").build());
        lgas.add(Lgas.builder().lgaName("Kosofe").stateCode("LA").lgaCode("LA020").build());
        lgas.add(Lgas.builder().lgaName("LAXXXX").stateCode("LA").lgaCode("LAXXX").build());

        lgaRepository.saveAll(lgas);

        System.out.println("All LGAs seeded successfully.");
    }
}
