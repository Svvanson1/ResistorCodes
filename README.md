# ResistorCodes
You can see this Wikipedia page(https://en.wikipedia.org/wiki/Electronic_color_code#Resistor_color-coding) for a colorful chart, but the basic resistor color codes are:

black: 0, brown: 1, red: 2, orange: 3, yellow: 4, green: 5, blue: 6, violet: 7, gray: 8, white: 9

Each resistor will have at least three bands, with the first and second bands indicating the first two digits of the ohms value, and the third indicating the power of ten to multiply them by, for example a resistor with the three bands "yellow violet black" would be 47 * 10^0 ohms, or 47 ohms.

Most resistors will also have a fourth band that is either gold or silver, with gold indicating plus or minus 5% tolerance, and silver indicating 10% tolerance. Resistors that do not have a fourth band are rated at 20% tolerance. (There are also more specialized resistors which can have more bands and additional meanings for some of the colors, but this program has not added them)

This tool is used to decode this information for color banded resistors into a more easily read format.

examples, featuring some common resistor values

"brown black black"     =>           "10 ohms, 20%"
"brown black brown gold"   =>       "100 ohms, 5%"
"red red brown"     =>              "220 ohms, 20%"
"orange orange brown gold"   =>     "330 ohms, 5%"
"yellow violet brown silver"   =>   "470 ohms, 10%"
"blue gray brown"       =>          "680 ohms, 20%"
"brown black red silver"    =>       "1k ohms, 10%"
"brown black orange"      =>        "10k ohms, 20%"
"red red orange silver"     =>      "22k ohms, 10%"
"yellow violet orange gold"   =>    "47k ohms, 5%"
"brown black yellow gold"   =>     "100k ohms, 5%"
"orange orange yellow gold"   =>   "330k ohms, 5%"
"red black green gold"      =>       "2M ohms, 5%"
