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



(deftemplate MAIN::bearing_state_color
	(slot name_bearing_state_color)
	(slot description_bearing_state_color)
)

(deftemplate MAIN::bearing_state_mec
	(slot name_bearing_state_color)
	(slot name_bearing_state)
)

(deftemplate MAIN::leaf_state
    (slot leaf_state_color)
    (slot leaf_state_mec)
)


(defrule DIAGNOSTIC::check_mouthparts 
 (plant_type ceral)
 (not (life_cycle ripness))
=>
(assert (mouthparts sucking))
)

 
