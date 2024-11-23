package org.example.mobile;

import java.util.List;

public class MobilePhone {
    private String myNumber;
    private List<Contact> myContacts;


    public MobilePhone(String myNumber, List<Contact> myContacts) {
        this.myNumber = myNumber;
        this.myContacts = myContacts;
    }


    public String getMyNumber() {
        return myNumber;
    }


    public List<Contact> getMyContacts() {
        return myContacts;
    }


    public boolean addNewContact(Contact contact) {
        if (contact == null || contact.getName() == null || contact.getPhoneNumber() == null) {
            return false;
        }
        if (findContact(contact.getName()) >= 0) {
            return false;
        }
        return myContacts.add(contact);
    }


    public boolean updateContact(Contact oldContact, Contact newContact) {
        int position = findContact(oldContact);
        if (position <= 0) {
            return false;
        }
        myContacts.set(position, newContact);
        return true;
    }


    public boolean removeContact(Contact contact) {
        if(contact == null || findContact(contact) < 0) {
            return false; // Contact not found
        }
        return this.myContacts.remove(contact);
    }


    public int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }


    public int findContact(String name) {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            if (contact.getName().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }


    public Contact queryContact(String name) {
        int position = findContact(name);
        if(position < 0){
            return null;
        }
        return this.myContacts.get(position);
    }


    public void printContact() {
        for (int i = 0; i < myContacts.size(); i++) {
            Contact contact = myContacts.get(i);
            System.out.println((i + 1) + ". "+ contact.getName() + " ->" + contact.getPhoneNumber());
        }
    }
}
