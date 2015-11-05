(defmodule DIAGNOSTIC)

(deftemplate MAIN::pest
	(multislot  pest_name)
	(slot name_pest_family)
	(slot type_pest)
	(slot size)
	(slot color)
	(slot shape)
	(slot wings)
	(slot fly_ability)
	(slot body)
	(slot legs)
)

(deftemplate MAIN::plant
	(multislot name_plant)
	(slot latin_name)
	(slot family_plant)
	(slot plant_type)
	(slot root_type)
	(slot steam_type)
	(slot leaf_shape_type)
	(slot brushing_type)
	(slot flowers_type_sex)
	(slot bearing_type)
	(slot seed_type)
	(slot frost_stable)
	(slot dry_stable )
)


(deftemplate MAIN::bearing_state
	(slot bearing_state_color)
	(slot bearing_state_mec)
)

(deftemplate MAIN::leaf_state
    (slot leaf_state_color)
    (slot leaf_state_mec)
    (slot leaf_type)
)


(deftemplate MAIN::bud_state
    (slot bud_type)
    (slot bud_state_color)
    (slot bud_state_mec)
)


(deftemplate MAIN::ceral_organogenesis
    (slot name_of_stage)
    (multislot part_of_plants)
)

(deftemplate MAIN::inspection
    (multislot name_plant)
    (slot id_teritory)
    (slot size_plant)
    (slot life_cycle)
    (slot data_inspection)
    (slot hr_id)
)

(defrule DIAGNOSTIC::check_mouthparts 
 (plant_type ceral)
 (not (life_cycle ripness))
=>
(assert (mouthparts sucking))
)

(deffacts genus-included
 (genus Root Aphids)
 (genus Ground Beetles)
 (genus Mealybugs)
 (genus Selenothrips gramineum)
 (genus Haplothrips tritici)
 (genus Helicotylenchus)
 (genus Hemicriconemoides)
 (genus Heterodera)
 (genus Hirschmanniella)
 (genus Longidorus)
 (genus Meloidogyne)
 (genus Meloidodera)
 (genus Paratylenchus)
 (genus Pratylenchus)
 (genus Radopholus)
 (genus Rotylenchulus)
 (genus Trichodorus)
 (genus Tylenchorhynchus)
 (genus Tylenchulus)
 (genus Xiphinema)
 )


(deffacts pests-indicated
 (pest_id Aphidae)
 (pest_id Carabidae)
 (pest_id Pseudococcidae)
 (pest_id Thripidae)
 (pest_id Haplothrips tritici)
 (pest_id Helicotylenchus)
 (pest_id Hemicriconemoides)
 (pest_id Heterodera)
 (pest_id Hirschmanniella)
 (pest_id Longidorus)
 (pest_id Meloidogyne)
 (pest_id Meloidodera)
 (pest_id Paratylenchus)
 (pest_id Pratylenchus)
 (pest_id Radopholus)
 (pest_id Rotylenchulus)
 (pest_id Trichodorus)
 (pest_id Tylenchorhynchus)
 (pest_id Tylenchulus)
 (pest_id Xiphinema)
 )


 
