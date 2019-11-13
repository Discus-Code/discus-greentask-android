package org.discusinstitute.greentaskandroid.discus.data

//Used https://www.csvjson.com/csv2json to create this from the spreadshet.
//note the headers.
val tasks = """[
  {
    "theme_week": "Car",
    "action_id": 1,
    "action_name": "Car Wash",
    "action_text": "Get your car washed at a commercial car wash!",
    "factoid": "The average homeowner uses 116 gallons of water to wash a car! Most commercial car washes average less than 30 gallons per car.",
    "source": "https://cfpub.epa.gov/npstbx/files/KSMO_CarWashing.pdf, https://www.carwash.org/docs/default-document-library/Water-Use-in-the-Professional-Car-Wash-Industry.pdf",
    "tags": "driving",
    "based_on_initiative": "N/A"
  },
  {
    "theme_week": "Errands",
    "action_id": 2,
    "action_name": "Combine Errands",
    "action_text": "Whenever you can, combine errands in order to reduce unnecessary driving.",
    "factoid": "Warm engines run more efficiently than cold ones so combining short car trips into one increases the energy efficiency of your errands as a whole.",
    "source": "https://blog.epa.gov/2010/08/26/car-maintenance-is-a-must/",
    "tags": "driving",
    "based_on_initiative": "N/A"
  },
  {
    "theme_week": "Car",
    "action_id": 3,
    "action_name": "Don't Top Off",
    "action_text": "Don’t top off your gas after you hear the click at the pump!",
    "factoid": "The extra gas added can evaporate into toxic fumes and frequently spills into our waterways and drinking water.",
    "source": "https://drivecleantexas.org/texas-air-quality/faq/",
    "tags": "driving",
    "based_on_initiative": "N/A"
  },
  {
    "theme_week": "Home",
    "action_id": 4,
    "action_name": "Thermostat",
    "action_text": "Treat the heater and air conditioner like a light, and turn it off whenever you step out.",
    "factoid": "There is a common myth that it is more efficient to leave the AC or heat running than to turn it off and on again. This is not the case.",
    "source": "https://learn.compactappliance.com/setting-home-ac/",
    "tags": "energy efficiency",
    "based_on_initiative": "#Thermostat"
  },
  {
    "theme_week": "Errands",
    "action_id": 6,
    "action_name": "Less Packaging",
    "action_text": "Choose minimally packaged goods and buy in bulk when possible!",
    "factoid": "Overpackaged goods deplete natural resources, waste energy during production, and increase pollution and waste.",
    "source": "https://www.researchgate.net/publication/229796182_The_Environmental_Impacts_of_Packaging",
    "tags": "consumption",
    "based_on_initiative": "#LessPackaging"
  },
  {
    "theme_week": "Eating",
    "action_id": 7,
    "action_name": "Eat Green",
    "action_text": "Eat less meat, poultry, and fish for a lower carbon footprint!",
    "factoid": "When compared to staples like potatoes, wheat, and rice, the impact of beef per calorie is even more extreme, requiring 160 times more land and producing 11 times more greenhouse gases.",
    "source": "https://www.theguardian.com/environment/2014/jul/21/giving-up-beef-reduce-carbon-footprint-more-than-cars",
    "tags": "carbon footprint",
    "based_on_initiative": "#EatGreen"
  },
  {
    "theme_week": "Errands",
    "action_id": 8,
    "action_name": "Green Coffee Cup",
    "action_text": "Bring a reusable cup or bottle for your daily coffee!",
    "factoid": "Disposable paper coffee cups are not recyclable because of their plastic lining. Each disposable coffee cup is responsible for 0.24 lbs of carbon (C02) greenhouse gas emissions.",
    "source": "http://www.recyclingadvocates.org/single-use-coffee-cup-reduction/",
    "tags": "consumption",
    "based_on_initiative": "#SustainableSupplies"
  },
  {
    "theme_week": "Errands",
    "action_id": 9,
    "action_name": "Refillable Bottles",
    "action_text": "Bring a refillable water bottle to avoid buying plastic bottles.",
    "factoid": "Recycling bottles helps, but simply producing bottles releases 2.5 million tons of carbon dioxide into the atmosphere annually because 17 million barrels of oil are required to produce a year’s supply. That’s enough oil to fuel 1.3 million cars for the year or power 190,000 homes!",
    "source": "https://greenerideal.com/infographics/the-environmental-impact-of-plastic-water-bottles/",
    "tags": "consumption",
    "based_on_initiative": "#Refillable"
  },
  {
    "theme_week": "Errands",
    "action_id": 10,
    "action_name": "Reusable Bag",
    "action_text": "Bring your own reusable bags to work, school, or when you shop. Pass on the plastic bag and start carrying your own reusable totes.",
    "factoid": "Make sure to always use your reusable bags. A cotton tote needs to be reused 131 times to break even with a  plastic bags in terms of its production's climate impact.",
    "source": "https://stanfordmag.org/contents/paper-plastic-or-reusable",
    "tags": "consumption",
    "based_on_initiative": "#ReusableBag"
  },
  {
    "theme_week": "Kitchen",
    "action_id": 11,
    "action_name": "Dishwasher",
    "action_text": "If you have a dishwasher, don't pre-rinse, just fully load it to use less than 15% water of handwashing.",
    "factoid": "A large load of dishes would take 170.5 litres of water to wash by hand, compared to less than 20 litres in a dishwasher.",
    "source": "https://blogs.unimelb.edu.au/sciencecommunication/2017/09/29/is-your-dishwasher-saving-the-planet/",
    "tags": "water consumption",
    "based_on_initiative": "#Dishwasher"
  },
  {
    "theme_week": "Electric",
    "action_id": 12,
    "action_name": "Lights Off",
    "action_text": "Turn the lights off if you don’t need them.",
    "factoid": "If you turn off the lights whenever you leave a room, you can reduce greenhouse gas emissions by 0.15 pounds per hour.",
    "source": "https://www.bu.edu/sustainability/what-you-can-do/ten-sustainable-actions/turn-off-the-lights/",
    "tags": "energy efficiency",
    "based_on_initiative": "#LightsOff"
  },
  {
    "theme_week": "Errands",
    "action_id": 13,
    "action_name": "Avoid Cars",
    "action_text": "Bike, walk or take public transport. Save the car trips for when you’ve got a big group.",
    "factoid": "Subways and metros produce on average 76% lower greenhouse gas emissions per passenger mile than an average car. Trams produce 62% less and bus transit produces 33% less.",
    "source": "https://www.transit.dot.gov/regulations-and-guidance/environmental-programs/transit-environmental-sustainability/transit-role",
    "tags": "energy efficiency",
    "based_on_initiative": "#AvoidCars"
  },
  {
    "theme_week": "Electric",
    "action_id": 14,
    "action_name": "Power Strip",
    "action_text": "Save electricity by plugging appliances into a power strip which you switch off completely when not in use, including your computer.",
    "factoid": "“Phantom loads,” or the electricity used by electronics when they are \"turned off\" or in standby mode, are a major source of energy waste. In fact, it is estimated that 75% of the energy used to power household electronics is consumed when they are switched \"off.",
    "source": "https://www.energysage.com/energy-efficiency/101/ways-to-save-energy/",
    "tags": "energy efficiency",
    "based_on_initiative": "#SaveElectricity"
  },
  {
    "theme_week": "Water",
    "action_id": 15,
    "action_name": "Short Shower",
    "action_text": "Take a shorter shower today.",
    "factoid": "An average shower uses about 5 gallons of water per minute. If you shorten your shower by 2 minutes, you can cut your water use by 10 gallons.",
    "source": "http://www.bu.edu/sustainability/what-you-can-do/ten-sustainable-actions/take-shorter-showers/",
    "tags": "water consumption",
    "based_on_initiative": "#ShortShowers"
  },
  {
    "theme_week": "Home",
    "action_id": 16,
    "action_name": "Get a Plant",
    "action_text": "Indoor plants provide clean your air and enhance mood",
    "factoid": "Indoor plants increase your productivity and health. Check out NASA's top 18 houseplants!",
    "source": "https://en.wikipedia.org/wiki/NASA_Clean_Air_Study",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Electric",
    "action_id": 17,
    "action_name": "Pick LED Lightbulbs!",
    "action_text": "Choose bluer bulbs for active areas and redder for relaxation. Or get smart bulbs that automatically adjust color.",
    "factoid": "LEDs last 20x longer than standard bulbs and use 1/6 the electricity. Overall cost 1/5 over the 23 years the LED will last.",
    "source": "https://www.thesimpledollar.com/the-light-bulb-showdown-leds-vs-cfls-vs-incandescent-bulbs-whats-the-best-deal-now-and-in-the-future/",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Health",
    "action_id": 18,
    "action_name": "Take a Walk",
    "action_text": "Take a walk! Exposure to sunlight helps you sleep better, plus exercise.",
    "factoid": "Sunlight in the morning gives you energy to achieve your goals.",
    "source": "http://www.lrc.rpi.edu/programs/daylighting/pdf/DaylightBenefits.pdf",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Health",
    "action_id": 19,
    "action_name": "Sunset for Your Screens",
    "action_text": "Reduce eyestrain by turning on the sunset function for your phone and computers",
    "factoid": "Typically found under settings and \"display & brightness\" \"night shift\" for apple devices.",
    "source": "https://www.howtogeek.com/199303/reduce-eye-strain-and-get-better-sleep-by-using-f.lux-on-your-computer/",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Home",
    "action_id": 20,
    "action_name": "Check Your Door",
    "action_text": "Do you see daylight around your door? Get a roll of peel and stick weatherstripping to fix it.",
    "factoid": "Also put a stick on doorsweep if the botton has a gap. Be green and save money! Video How to https://youtu.be/zvga1Bv8UfQ",
    "source": "https://youtu.be/zvga1Bv8UfQ",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Outdoors",
    "action_id": 21,
    "action_name": "Water a Street Tree",
    "action_text": "If you experience a dought or dry weather, help your friendly neighborhood tree.",
    "factoid": "Water stress is the most common cause of tree deaths.",
    "source": "https://www.urbanforestry.frec.vt.edu/documents/articles/WisemanArboristNews13(3).pdf",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Home",
    "action_id": 22,
    "action_name": "Close the Curtains",
    "action_text": "When it is cold, close your curtains after dark to keep the cold air out.",
    "factoid": "Harvest sun's warmth during the day and save up to 25% of heating bill with thick drapes.",
    "source": "https://homeguides.sfgate.com/types-curtains-keep-heat-in-98303.html",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Health",
    "action_id": 23,
    "action_name": "Batteries and Flashlights",
    "action_text": "Check your battery strength. Know where your flashlights are so you can find them in the dark.",
    "factoid": "Solar phone chargers and camping lights are great options too.",
    "source": "",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Outdoors",
    "action_id": 24,
    "action_name": "Get Non-Toxic Ice Melt",
    "action_text": "Melt snow and ice while protecting pets and plants with non-toxic products, sand or ashes",
    "factoid": "If you wait too long, the store will run out.",
    "source": "https://safepaw.com/non-toxic-ice-melter/",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Laundry",
    "action_id": 25,
    "action_name": "Wash Fleece on Regular",
    "action_text": "Surprise! More bad plastic microfibers are released when fleece clothes are washed on delicate.",
    "factoid": "British study shows that  standard wash cycles release hundreds of thousands less plastic microfibres. Probably because delicate uses more water.",
    "source": "https://www.theguardian.com/environment/2019/sep/26/vicious-cycle-delicate-wash-releases-more-plastic-microfibres",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Laundry",
    "action_id": 26,
    "action_name": "Ultra Concentrated Detergent",
    "action_text": "Measure carefully so not to overdo the detergent. Get the type for your washer!",
    "factoid": "Ultra concentrated laundry detergent cuts plastic, shipping costs and is easy to store & carry. Top and front loaders need different formaula.",
    "source": "https://lancaster.unl.edu/home/articles/2007/laundryconcentrate.shtml",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Laundry",
    "action_id": 27,
    "action_name": "Vinegar for Fabric Softener",
    "action_text": "Cheaper and greener to use vinegar to get the soap out.",
    "factoid": "Use cleaning vinegar of about 5% acetic acid",
    "source": "https://www.treehugger.com/htgg/how-to-go-green-laundry.html",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Laundry",
    "action_id": 29,
    "action_name": "Clean Your Dryer Vent",
    "action_text": "Yes the tube that takes your lint outside. Prevents fires and makes your drying quicker and greener.",
    "factoid": "Call a pro or check out How to Videos. Or be so green that you hang it all to dry!",
    "source": "https://www.treehugger.com/htgg/how-to-go-green-laundry.html",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Laundry",
    "action_id": 30,
    "action_name": "Dryer Balls v Dryer Sheets",
    "action_text": "Use wool dryer balls to speed drying and cut static by fluffing your clothes.",
    "factoid": "Lose the chemicals and save time and electricity.",
    "source": "https://thehomemadeexperiment.com/how-to-use-wool-dryer-balls/",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Health",
    "action_id": 31,
    "action_name": "Bar Soap is Greenest",
    "action_text": "Liquid soap makes 7x emissions and leaves a plastic bottle. Bar soap has fewer unhealthy chemicals.",
    "factoid": "Both are effective at cleaning your hands and fighting germs.",
    "source": "https://www.treehugger.com/cleaning-organizing/go-plastic-free-global-handwashing-day.html",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Kitchen",
    "action_id": 32,
    "action_name": "Indoor Herb Growing",
    "action_text": "Chives, parsley, tarragon, oregano and thyme can grow indoors during the winter.",
    "factoid": "Greener and fresher than a box from the store. A sunny window is ideal.",
    "source": "https://www.gardenguides.com/110807-grow-herbs-indoors-during-winter.html",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Autumn",
    "action_id": 33,
    "action_name": "Change Your Filters",
    "action_text": "If you have an air heater, replace its filter to save up 15% on your heat.",
    "factoid": "Saves wear and tear on your unit too.",
    "source": "http://blog.filtersnap.com/can-i-save-money-by-changing-my-air-filter/",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Autumn",
    "action_id": 34,
    "action_name": "Get Your Heating Checkup",
    "action_text": "Don't wait til its cold to find out your heat is not working",
    "factoid": "Regular maintenance can save from 5%-40% energy used.",
    "source": "https://buildingefficiencyinitiative.org/articles/studies-show-hvac-system-maintenance-saves-energy",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Water",
    "action_id": 35,
    "action_name": "Fix Leaky Faucets",
    "action_text": "Fix leaky faucets to save up to 3,000 gallons of water per faucet and 500 gallons per showerhead. Avoid wasting energy if the leak is hot water.",
    "factoid": "The average household's leaks can account for more than 10,000 gallons of water wasted totaling more 1 trillion gallons annually in the US..",
    "source": "https://19january2017snapshot.epa.gov/www3/watersense/pubs/fixleak.html",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Water",
    "action_id": 36,
    "action_name": "Is Your Toilet Leaking?",
    "action_text": "Hard to tell, so check for a leak with simple food coloring. https://www.youtube.com/watch?v=xj2rW0_titE",
    "factoid": "The average leaky toilet can waste about 200 gallons of water per day.",
    "source": "https://19january2017snapshot.epa.gov/www3/watersense/pubs/fixleak.html",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Water",
    "action_id": 37,
    "action_name": "Outdoor Hose?",
    "action_text": "Turn your outdoor hose off for the winter from your indoor cutoff valve. Then drain out the hose. Frozen pipes can burst and flood your house.",
    "factoid": "Get any leaks at this faucet fixed too.",
    "source": "",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Autumn",
    "action_id": 38,
    "action_name": "Lock Your Windows",
    "action_text": "Presses the window against the seal to cut drafts and save money.",
    "factoid": "The easiest green boost you can do. Bosts safety too.",
    "source": "https://www.energy2030together.com/en/our-energy-use/lock-your-windows…and-other-tips-to-save",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Autumn",
    "action_id": 39,
    "action_name": "Window Insulating Plastic",
    "action_text": "Quick, cheap and easy way to save up to ${'$'}20 per window if you have old units.",
    "factoid": "Get a kit from the hardware store. Tape and blow dry it on.",
    "source": "https://home.howstuffworks.com/green-living/conserve-energy-plastic-insulation.htm",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Eating",
    "action_id": 40,
    "action_name": "Keep Food Fresh",
    "action_text": "Here's a guide for making food last in the fridge. r https://www.businessinsider.com/best-way-to-store-food-2016-2#dont-chop-fruit-veggies-or-meat-until-youre-ready-to-use-them-since-exposure-to-the-air-will-make-those-foods-dry-out-or-go-bad-faster-chopping-up-veggies-also-unleashes-the-nutrients-and-bioactive-compounds-in-them-so-its-best-to-wait-until-youre-ready-to-eat-10",
    "factoid": "America wastes almost 40% of food produced and some of that occurs in your house.",
    "source": "https://www.realsimple.com/food-recipes/shopping-storing/food/store-food-refrigerato",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Eating",
    "action_id": 41,
    "action_name": "Compost",
    "action_text": "Many towns or markets offer compost dropoffs. You can keep scraps in freezer or fridge to avoid fruitflies.",
    "factoid": "Compost enriches soil and cuts GHG. Composting at home can be done too. Here are some tips https://www.epa.gov/recycle/composting-home",
    "source": "https://www.epa.gov/recycle/composting-home",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Eating",
    "action_id": 42,
    "action_name": "Dish Towels",
    "action_text": "Use reusable dishtowels.",
    "factoid": "Just wash in warm water.",
    "source": "",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Eating",
    "action_id": 43,
    "action_name": "Cloth Napkins",
    "action_text": "Choose easy wash fabrics and patterns can hide spots.",
    "factoid": "For bargain fancy napkins you can visit estate sales.",
    "source": "https://www.thekitchn.com/how-cloth-napkins-became-a-practical-everyday-choice-for-me-218066",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Eating",
    "action_id": 44,
    "action_name": "Bring Your Own Containers for Leftovers",
    "action_text": "Less plastic for your doggy bags.",
    "factoid": "Healthier for you and the planet.",
    "source": "https://healthfully.com/173172-what-are-the-dangers-of-plastic-food-storage-containers.html",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Eating",
    "action_id": 45,
    "action_name": "Non Plastic Food Containers",
    "action_text": "Glass and steel are cleaner than plastic because the nonporous surfaces don’t absorb food or bacteria.",
    "factoid": "Food can be put in glass and steel containers while hot. Many are oven safe.",
    "source": "",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Autumn",
    "action_id": 46,
    "action_name": "Window Airconditioner",
    "action_text": "If you have one, remove it for the winter or buy an insulating cover",
    "factoid": "Here's how. https://homeguides.sfgate.com/insulate-cold-air-leak-around-air-conditioner-43004.html",
    "source": "https://homeguides.sfgate.com/insulate-cold-air-leak-around-air-conditioner-43004.html",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Health",
    "action_id": 47,
    "action_name": "Unscented Products",
    "action_text": "Many scented products contain harmful Volatile Organic Compounds (VOCs)",
    "factoid": "An EPA study found levels of common volatile organic pollutants (VOC) to be 2 to 5 times higher inside homes than outside",
    "source": "https://www.ncbi.nlm.nih.gov/pmc/articles/PMC3018511/",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Home",
    "action_id": 48,
    "action_name": "Take Care of Gutters",
    "action_text": "It isn't green to get water damage. Clean the gutters and add extenders if the downspouts are too close to the building",
    "factoid": "Call a pro or get out the ladder if you can do so safely",
    "source": "",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Finances",
    "action_id": 49,
    "action_name": "Renewable Tax Credits For Now",
    "action_text": "Renewable energy tax credits for residential and commercial will be 30% only til 12/31/19",
    "factoid": "26% for systems placed in service during 2020; or 22% for systems placed in service during 2021.",
    "source": "https://www.energystar.gov/about/federal_tax_credits",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Finances",
    "action_id": 50,
    "action_name": "Utility Efficiency Incentives",
    "action_text": "Check your local power company for utility efficiency incentives.",
    "factoid": "North Carolina State University’s Clean Energy Technology Center for state by state incentive information at http://www.dsireusa.org/",
    "source": "",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Halloween",
    "action_id": 54,
    "action_name": "Halloween Extras",
    "action_text": "Still need some last-minute items? Hit the thrift shop!",
    "factoid": "",
    "source": "",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Halloween",
    "action_id": 55,
    "action_name": "Jack-o-lanterns",
    "action_text": "Compost the pumpkin guts. You can save the seeds for planting or toast them to eat.",
    "factoid": "It's best not to use parafin candles that emit soot and fumes.",
    "source": "http://www.sustainablebabysteps.com/green-halloween.html#",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Halloween",
    "action_id": 56,
    "action_name": "No Plastic Cobwebs Please",
    "action_text": "Birds and bats can be caught and killed by fake webs.",
    "factoid": "This happens most frequently when webs are stretched across doorways or other openings.",
    "source": "https://www.gardenexperiments.com/its-halloween-the-dangers-of-fake-spider-webs/",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Halloween",
    "action_id": 57,
    "action_name": "Recycle Wrappers",
    "action_text": "Recycle the candy wrappers in a Zero Waste Box from TerraCycle.",
    "factoid": "You could go in on it with friends, neighbors, or your neighborhood school.",
    "source": "https://livegreen.recyclebank.com/29-fun-ways-to-have-a-happy-sustainable-halloween",
    "tags": "",
    "based_on_initiative": ""
  },
  {
    "theme_week": "Halloween",
    "action_id": 58,
    "action_name": "Inflatables and Lights",
    "action_text": "Put them on a timer so that they aren't using electricity at 2:00am or the middle of the work day.",
    "factoid": "A typical inflatable consumes 150 to 200 watts per hour. If they function 10 hours per day,  you’ll spend an extra ${'$'}10 a month per inflatable.",
    "source": "https://www.yahoo.com/news/7-reasons-to-skip-those-inflatable-prefab-105236392550.html",
    "tags": "",
    "based_on_initiative": ""
  }
]"""