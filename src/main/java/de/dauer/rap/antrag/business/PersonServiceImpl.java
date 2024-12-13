package de.dauer.rap.antrag.business;

import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService{

    @Override
    public String konvertireName(String vorname, String name) {

        if (vorname==null && name==null)
            return null;
        else if(vorname==null)
            return name;
        else if(name==null)
            return vorname;
        return vorname.concat(" ").concat(name);
    }
}

