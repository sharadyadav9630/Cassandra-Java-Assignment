package org.gcs.cassandra.utils;

import org.gcs.cassandra.dao.Bird;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

public class HelperUtil {

    private HelperUtil() {
    }

    public static List<Bird> getBirds() {
        return BirdSupplier.get();
    }

    private static final Supplier<List<Bird>> BirdSupplier = () ->
            Arrays.asList(
                    Bird.builder().id(UUID.fromString("59b924-34cb-4467-9cd9-a3ce62c1c8d0f7")).name("House sparrow")
                            .birdCharacteristic(new HashSet<>(Arrays.asList("small bird that has a typical length of 16 cm and a mass of 24–39.5 g",
                                                 "Females and young birds are coloured pale brown and grey, and males have brighter black, white, and brown markings"))).build(),

                    Bird.builder().id(UUID.fromString("7bff64e7-fb12-420b-a2b5-bd966bb31588")).name("Barn owl")
                            .birdCharacteristic(new HashSet<>(Arrays.asList("rounded wings", "a short tail, sharp talons","a medium-length hooked beak and a smoothly rounded head without ear tufts"))).build(),

                    Bird.builder().id(UUID.fromString("673f1001-07f0-4493-8550-3d015e96e48a")).name("Common buzzard")
                            .birdCharacteristic(new HashSet<>(Arrays.asList("rounded wings, and a short neck and tail", "variable in colour from all dark brown to much paler variations, all have dark wingtips and a finely barred tail"))).build(),

                    Bird.builder().id(UUID.fromString("7bff64e7-fb12-420b-a2b5-bd966bb31588")).name("Golden eagle")
                            .birdCharacteristic(new HashSet<>(Arrays.asList("large and powerful falcon", "longer wings and a longer tail than the rarer white-tailed eagle","Young birds have white patches in their wings and a white base to the tail"))).build(),

                    Bird.builder().id(UUID.fromString("74fba515-bbb3-4146-b696-79618ceaa270")).name("Peregrine falcon")
                            .birdCharacteristic(new HashSet<>(Arrays.asList("rounded wings, and a short neck and tail", "It has long, broad, pointed wings and a relatively short tail", "It is blue-grey above, with a blackish top of the head and an obvious black moustache that contrasts with its white face"))).build(),

                    Bird.builder().id(UUID.fromString("cd05e2f0-e4f5-4ba9-8b96-43e3f0570716")).name("Common raven")
                            .birdCharacteristic(new HashSet<>(Arrays.asList("big black bird", "a member of the crow family", "smassive - the biggest member of the crow family", "lt is all black with a large bill, and long wings","In flight, it shows a diamond-shaped tail"))).build(),

                    Bird.builder().id(UUID.fromString("c1f78ad2-0920-4e15-80c7-c9d3a8548391")).name("Common blackbird")
                            .birdCharacteristic(new HashSet<>(Arrays.asList("males are black with bright orange-yellow beak and yellow eye-ring", "Females are brown often with spots and streaks on their breasts and brown beak", "Blackbird is one of the most common UK birds and one of the most striking" , "Its mellow song is also a favourite"))).build(),

                    Bird.builder().id(UUID.fromString("ab75a3f9-1f32-4b28-8b82-f9478bb811ea")).name("European robin")
                            .birdCharacteristic(new HashSet<>(Arrays.asList("small insectivorous songbird", "The male and female are similar in coloration, with an orange breast and face lined with grey, brown upperparts, and a whitish belly", "The bill and eyes are black"))).build(),

                    Bird.builder().id(UUID.fromString("6e2f21f5-ddc3-4c46-8508-1ec5a83c2e87")).name("Eurasian whimbrel")
                            .birdCharacteristic(new HashSet<>(Arrays.asList("a shorter bill with a more down-curved tip", "obvious dark eye-stripe and pale supercilium", "he head also has a notably pale median crown-stripe between the two broad black stripes that form a dark skull cap in profile"))).build(),

                    Bird.builder().id(UUID.fromString("1903e880-a9ff-4e47-86b1-025fb6ac08a4")).name("Western jackdaw")
                            .birdCharacteristic(new HashSet<>(Arrays.asList("small, black crow with a distinctive silvery sheen to the back of its head", "pale eyes are also noticeable", "commonly nest in chimneys, buildings, rock crevices and tree holes"))).build(),

                    Bird.builder().id(UUID.fromString("fd9b13db-d9cb-466d-8ef6-ff7f5cabef2b")).name("Goldcrest")
                            .birdCharacteristic(new HashSet<>(Arrays.asList("goldcrest is the UKs smallest bird", "dull greyish-green with a pale belly and a black and yellow stripe on their heads", "thin beak is ideally suited for picking insects out from between pine needles"))).build()

            );
}