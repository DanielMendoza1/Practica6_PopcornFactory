package daniel.ornelas.popcornfactory

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_menu.*


class menu : AppCompatActivity() {

    var adapter: AdapterPeliculas? = null
    var peliculas = ArrayList<Pelicula>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        cargarPeliculas()

        adapter = AdapterPeliculas(this, peliculas)
        grid_movies.adapter = adapter

    }
    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)

        var bundle = intent?.extras

        var id_pelicula = bundle?.getInt("id_pelicula")
        var cliente = bundle?.get("cliente")
        peliculas[id_pelicula!!].seats.add(cliente as Cliente)
    }

    fun cargarPeliculas() {
        peliculas.add(
            Pelicula(
                "Big Hero 6",
                R.drawable.bighero6,
                R.drawable.headerbighero6,
                "When a devastating event befalls the city of San Fransokyo and catapults Hiro into the\n" +
                        "midst of danger, he turns to Baymax and his close friends adrenaline junkie Go Go\n" +
                        "Tomago, neatnik Wasabi, chemistry whiz Honey Lemon and fanboy Fred. Determined to\n" +
                        "uncover the mystery, Hiro transforms his friends into a band of high-tech heroes called\n" +
                        "Big Hero 6.", arrayListOf<Cliente>()
            )
        )
        peliculas.add(
            Pelicula(
                "Leap year",
                R.drawable.leapyear,
                R.drawable.leapyearheader,
                "A woman who has an elaborate scheme to propose to her boyfriend on Leap Day, an Irish\n" +
                        "tradition which occurs every time the date February 29 rolls around, faces a major setback\n" +
                        "when bad weather threatens to derail her planned trip to Dublin. With the help of an\n" +
                        "innkeeper, however, her cross-country odyssey just might result in her getting engaged.",
                arrayListOf<Cliente>()
            )
        )
        peliculas.add(
            Pelicula(
                "Men in Black",
                R.drawable.mib,
                R.drawable.mibheader,
                "Based off of the comic book. Unbeknownst to other people, there is a private agency code\n" +
                        "named MiB. This agency is some kind of extra terrestrial surveillance corporation. Then,\n" +
                        "one of the agency's finest men only going by the name (Tommy Lee Jones) , is\n" +
                        "recruiting for a new addition to the agency. He has chosen James Edwards (Will Smith) of\n" +
                        "the N.Y.P.D. Then, one day, a flying saucer crashes into Earth. This was an alien a part of\n" +
                        "the race. He takes the body of a farmer (Vincent Donofrio) and heads to New York.\n" +
                        "He is searching for a super energy source called; The Galaxy;. Now, Agents J and K must\n" +
                        "stop the bug before it can escape with the galaxy.",
                arrayListOf<Cliente>()
            )
        )
        peliculas.add(
            Pelicula(
                "Toy Story",
                R.drawable.toystory,
                R.drawable.toystoryheader,
                "Toy Story is about the secret life of toys; when people are not around. When Buzz\n" +
                        "Lightyear, a space-ranger, takes Woody's place as Andy's favorite toy, Woody doesn't like\n" +
                        "the situation and gets into a fight with Buzz. Accidentaly Buzz falls out the window and\n" +
                        "Woody is accused by all the other toys of having killed him. He has to go out of the house\n" +
                        "to look for him so that they can both return to Andys room. But while on the outside they\n" +
                        "get into all kind of trouble while trying to get home.",
                arrayListOf<Cliente>()
            )
        )
        peliculas.add(
            Pelicula(
                "Inception",
                R.drawable.inception,
                R.drawable.inceptionheader,
                "Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction, stealing\n" +
                        "valuable secrets from deep within the subconscious during the dream state, when the\n" +
                        "mind is at its most vulnerable. Cobb's rare ability has made him a coveted player in this\n" +
                        "treacherous new world of corporate espionage, but it has also made him an international\n" +
                        "fugitive and cost him everything he has ever loved. Now Cobb is being offered a chance at\n" +
                        "redemption.",
                arrayListOf<Cliente>()
            )
        )
        peliculas.add(
            Pelicula(
                "1917",
                R.drawable.guerra,
                R.drawable.guerraheader,
                "British trenches somewhere in France. World war has been going on for the third year,\n" +
                        "heroic illusions have dissipated; general mood - boredom and fatigue. Stuff the belly,\n" +
                        "sleep, return home to Christmas Eve. On another quiet day, when nothing happens, two\n" +
                        "young soldiers, Blake and Schofield, are summoned to the general, who instructs them to\n" +
                        "send an important message to Colonel MacKenzie in the Second Devonshire Battalion,\n" +
                        "whose telephone connection was cut off by the enemy.",
                arrayListOf<Cliente>()
            )
        )
        peliculas.add(Pelicula("Fantastic beasts", R.drawable.fantasticbeasts, R.drawable.fantasticbeastsheader,
                "In 1926, British wizard and \"magizoologist\" Newton \"Newt\" Scamander arrives in New York City. He encounters Mary " +
                "Lou Barebone, the non-magical (\"No-Maj\" or \"Muggle\") head of the New Salem Philanthropic Society, who preac" +
                "hes that witches and wizards are real and dangerous. Attempting to recapture a Niffler that escaped from his suitc" +
                "ase of magical creatures, Newt meets No-Maj Jacob Kowalski, an aspiring baker, and they unwittingly swap suitcases. "
                , arrayListOf<Cliente>()))

        peliculas.add(Pelicula("The Aeronauts",R.drawable.aeronauts, R.drawable.aeronautsheader, "In 1862 London, scientist" +
                " James Glaisher and his pilot Amelia arrive for the launch of the largest balloon ever constructed. Despite being haunted " +
                "by a vision of her late husband Pierre, Amelia keeps up the brave front and the balloon successfully launches to a cheering " +
                "crowd. In a flashback, James appears before the Royal Society and explains his theory that the weather can be predicted, but " +
                "his fellow scientists mock him and refuse to finance his studies. ", arrayListOf<Cliente>()))

        peliculas.add(Pelicula("Spiderman into the spiderverse", R.drawable.spiderverse, R.drawable.spiderverseheader, "Miles Morales," +
                " a teenager who admires Spider-Man, struggles living up to the expectations of his parents, especially his father, police officer " +
                "Jefferson Davis, who sees Spider-Man as a menace. After school, Miles secretly visits his uncle Aaron Davis, who brings Miles to an" +
                " abandoned subway station where he can paint graffiti.", arrayListOf<Cliente>()))

        peliculas.add(Pelicula("Harry Potter",R.drawable.harrypotter, R.drawable.harrypotterheader, "Late one night, Albus Dumbledore and Minerva McGonagall, " +
                "professors at Hogwarts School of Witchcraft and Wizardry, along with the school's groundskeeper Rubeus Hagrid, deliver a recently orphaned " +
                "infant named Harry Potter to his only remaining relatives, the Dursleys.",arrayListOf<Cliente>()))


    }
}