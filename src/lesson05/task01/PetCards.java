package lesson05.task01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**Класс картотеки домашних животных*/
public class PetCards {

    private Map<Integer, Pet> petCards = new HashMap();

    public void setPet(Pet pet) {
        if (this.petCards.containsValue(pet)) throw new ArrayStoreException("добавление дубликата"); //учитываем, что добавление дубликатов должно приводить к исключительной ситуации
        this.petCards.put(pet.getUid(), pet);
    }

    public Map<Integer, Pet> getPetCards() {
        return petCards;
    }

    //поиск животного по его кличке
    public Pet searchPet (String name) {
        Pet pet = null;
//        petCards.entrySet().contains(name);
        for (Map.Entry<Integer, Pet> entry : petCards.entrySet()) {
            Integer key = entry.getKey();
            Pet value = entry.getValue();
            if (value.getName().compareTo(name) == 0) {
                pet = value;
                break;
            }
        }
        return pet;
    }

    //изменение данных животного по его идентификатору
    public void changePet (Integer id, String name, Person owner, double weight) {
        this.petCards.get(id).setAll(name, owner, weight);
    }

    //вывод на экран списка животных в отсортированном порядке
    public void sortString () {
        List<Pet> list = new ArrayList<>(this.petCards.values());
        list.sort(Pet.CompByOwnerNameWeight);
        list.forEach(pet -> System.out.println(pet));
    }

    @Override
    public String toString() {
        String str = "";
        for (Map.Entry<Integer, Pet> entry : petCards.entrySet()) {
            Integer key = entry.getKey();
            Pet value = entry.getValue();
            str += "uid=" + key + ", name=" + value.getName() + ", owner=" + value.getOwner().getName() + ", weight=" + value.getWeight() + "\n";
        }
        return str;
    }
}
