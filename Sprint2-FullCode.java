import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {
    JFrame window;
    Container con;
    JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
    JLabel titleNameLabel, varLabel, varLabelNumber;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font normalFont = new Font("Times New Roman", Font.PLAIN, 20);
    JButton startButton, choice1, choice2, choice3, choice4;
    JTextArea mainTextArea;
    int varKnowledge, varWealth, varJustice, varLove;
    int varBeggar;
    String position;

    TitleScreenHandler tsHandler = new TitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    //ImageIcon logo = new ImageIcon(".//res//jackfrost.jpg");


    public static void main(String[] args) {

        new Game();
    }

    public Game() {

        window = new JFrame();
        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        //window.setIconImage(logo.getImage());
        con = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("Greed");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(Color.black);

        startButton = new JButton("BEGIN");
        startButton.setBackground(Color.black);
        startButton.setForeground(Color.white);
        startButton.setFont(normalFont);
        startButton.addActionListener(tsHandler);
        startButton.setFocusPainted(false);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);

        con.add(titleNamePanel);
        con.add(startButtonPanel);

        window.setVisible(true);
    }

    public void createGameScreen() {
        titleNamePanel.setVisible(false);
        startButtonPanel.setVisible(false);

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.black);
        con.add(mainTextPanel);
        mainTextArea = new JTextArea(" ");
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(normalFont);
        mainTextArea.setLineWrap(true);
        mainTextArea.setWrapStyleWord(true);
        mainTextArea.setEditable(false);

        mainTextPanel.add(mainTextArea);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.black);
        choiceButtonPanel.setLayout(new GridLayout(4, 1));
        con.add(choiceButtonPanel);
        choice1 = new JButton("Choice 1");
        choice1.setBackground(Color.black);
        choice1.setForeground(Color.white);
        choice1.setFont(normalFont);
        choice1.setFocusPainted(false);
        choice1.addActionListener(choiceHandler);
        choice1.setActionCommand("c1");
        choiceButtonPanel.add(choice1);
        choice2 = new JButton("Choice 2");
        choice2.setBackground(Color.black);
        choice2.setForeground(Color.white);
        choice2.setFont(normalFont);
        choice2.setFocusPainted(false);
        choice2.addActionListener(choiceHandler);
        choice2.setActionCommand("c2");
        choiceButtonPanel.add(choice2);
        choice3 = new JButton("Choice 3");
        choice3.setBackground(Color.black);
        choice3.setForeground(Color.white);
        choice3.setFont(normalFont);
        choice3.setFocusPainted(false);
        choice3.addActionListener(choiceHandler);
        choice3.setActionCommand("c3");
        choiceButtonPanel.add(choice3);
        choice4 = new JButton("Choice 4");
        choice4.setBackground(Color.black);
        choice4.setForeground(Color.white);
        choice4.setFont(normalFont);
        choice4.setFocusPainted(false);
        choice4.addActionListener(choiceHandler);
        choice4.setActionCommand("c4");
        choiceButtonPanel.add(choice4);

//		choice4.setContentAreaFilled(false);  // Disable highlighting on press!!!


        playerPanel = new JPanel();
        playerPanel.setBounds(100, 15, 600, 50);
        playerPanel.setBackground(Color.black);
        playerPanel.setLayout(new GridLayout(1, 4));
        con.add(playerPanel);
        varLabel = new JLabel("Wealth Var:");
        varLabel.setFont(normalFont);
        varLabel.setForeground(Color.white);
        playerPanel.add(varLabel);
        varLabelNumber = new JLabel();
        varLabelNumber.setFont(normalFont);
        varLabelNumber.setForeground(Color.white);
        playerPanel.add(varLabelNumber);

        playerSetup();

    }

    public void playerSetup() {

        varJustice = 0;
        varLove = 0;
        varKnowledge = 0;
        varWealth = 0;
        varBeggar = 1;
        //varLabelNumber.setText("" + varWealth);

        forrestIntro();
    }

    public void forrestIntro(){
        position = "forrestIntro";
        mainTextArea.setText("You awaken in the heart of a dense forest, the air thick with the scent of earth and damp leaves. You have no memory of who you are or how you got here. As you stand, you notice four distinct paths stretching out before you, each vanishing into the mysterious depths of the woods. The air hums with the unknown, and every path seems to whisper a different promise. Which one will you choose? ");
        choice1.setText("Go North");
        choice2.setText("Go East");
        choice3.setText("Go South");
        choice4.setText("Go West");
    }

    public void forrestPostIntro(){
        position = "forrestPostIntro";
        mainTextArea.setText("You've returned to you're place of origin, the leave crunch familiarly under your feet. The same options lay out in front of you just as they did before. The question once more arises again. Which one will you choose?");
        choice1.setText("Go North");
        choice2.setText("Go East");
        choice3.setText("Go South");
        choice4.setText("Go West");
    }


    public void castleIntro(){
        position = "castleIntro";
        mainTextArea.setText("As you approach, the castle looms ahead, its walls smooth and well-kept,The spires are sharp and clean, standing proudly against the sky, as if they were built only recently. The structure seems more like a fortress than a relic, with polished banners fluttering gently in the breeze. At the entrance, a lone guard stands watch, his posture rigid, yet there's an unmistakable irritation in the way he shifts his weight and scowls into the distance. His eyes dart around, as if searching for something—or someone—to vent his frustration on. He hasn't noticed you yet, but it’s clear he’s not in the mood for small talk. What will you do?");
        choice1.setText("Talk to the Guard");
        choice2.setText("Go East");
        choice3.setText("Go South");
        choice4.setText("Go West");
    }

    public void castlePostIntro(){
        position = "castlePostIntro";
        mainTextArea.setText("As the castle comes into view, just as you remember it—walls smooth and pristine, spires sharp against the sky. And there, just as before, is the guard. His irritation is palpable, a scowl etched across his face as he shifts his weight, glancing around with that same restless energy. You've seen this scene play out once, maybe more,. This time, though, you know what to expect. ");
        choice1.setText("Talk to the Guard");
        choice2.setText("Go East");
        choice3.setText("Go South");
        choice4.setText("Go West");
    }

    public void talkToGuard(){
        position = "talkToGuard";
        mainTextArea.setText("The guard’s eyes narrow as you approach, and he raises a hand to stop you before you can get too close. “No visitors,” he grumbles, his voice low and firm. “Lord’s orders.” There's a sharp edge to his tone, as if he's had to say this a hundred times today, and he’s growing tired of repeating himself.");
        choice1.setText("Is there anything I could do to go inside?");
        choice2.setText("Let me through, or you’ll regret it!");
        choice3.setText("Leave");
//If statement
        choice4.setText("When was the last time you even saw the Lord?");
    }

    public void talkToGuard2(){
        position = "talkToGuard2";
        mainTextArea.setText("He leans in slightly, lowering his voice as if sharing a secret. “The lord doesn’t want visitors,” he repeats, but there’s a subtle shift in his tone, a hint of possibility. “But… rules can be flexible, for the right price.” He glances around, making sure no one else is nearby, then looks back at you, eyes gleaming with a quiet, greedy anticipation. It’s clear that a few coins might loosen the gate’s stubborn lock. What’s your move?");
        choice1.setText("That's bribery!");
        choice2.setText("Slip the coin into the guard's palm");
        choice3.setText("Leave");
        choice4.setText("");
    }

    public void talkToGuard3(){
        position = "talkToGuard3";
        mainTextArea.setText(" The guard’s eyes widen slightly, caught off guard by your sudden boldness. He straightens, instinctively placing a hand on the hilt of his sword. “You think you can intimidate me?” he scoffs, Just try it and see what comes of you.");
        choice1.setText("Apologize and Leave");
        choice2.setText("Leave");
        choice3.setText("");
        choice4.setText("");
    }

    public void talkToGuardTriggered(){
        position = "talkToGuardTriggered";
        mainTextArea.setText("His expression shifts from irritation to a mix of surprise and caution. “I haven’t seen him for months,” he replies, his voice low. “No one has. The last time I spoke directly with him was three weeks ago, when I delivered the town's taxes.” He hesitates, glancing around as if to ensure no one is eavesdropping. “He seemed… different. His voice was raspy, and I swear I felt heat from his breath as he spoke to me. Now leave if you don't have any business... or coin”");
        choice1.setText("Leave");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void bribeGuard(){
        position = "bribeGuard";
        mainTextArea.setText(" The guard’s eyes gleam with greed as he takes a step closer, his irritation melting away in the face of opportunity. “Fine,” he mutters, snatching the coins from your palm. A sly grin spreads across his face as he gestures toward the gate. “You’ve got yourself a pass. Just don’t let him catch you snooping around. The lord doesn't take thievery lightly. ”" );
        choice1.setText("Enter the Castle");
        choice2.setText("Leave");
        choice3.setText("");
        choice4.setText("");
    }

    public void talkToGuard4(){
        position = "talkToGuard4";
        mainTextArea.setText("Your refusal catches him off guard, and a flash of frustration crosses his face. His annoyance simmers just below the surface, and he gestures angrily toward the gate. “If you’re not willing to play along, then turn around and leave! We don’t need anyone causing trouble in this town!” The weight of his anger lingers, and the atmosphere shifts, thick with tension.");
        choice1.setText("Apologize and Leave");
        choice2.setText("Leave");
        choice3.setText("");
        choice4.setText("");
    }

    public void enterCastle(){
        position = "enterCastle";
        mainTextArea.setText("You step into the castle, and an unsettling darkness envelops you. The air is heavy and stagnant, the only sound your footsteps echoing softly against the cold stone floor. Thick curtains hang in every window, blocking out any hint of light, and everything is coated in a grimy layer of soo, as if a fire just lightly touched every surface of the stone around you. The silence is oppressive, making you acutely aware of your own breath. Just as you start to feel the weight of isolation settle in, a savory aroma wafts toward you from the only entrance directly ahead. It’s an enticing scent that pulls you in, stirring your curiosity amid the eerie stillness. You hesitate for a moment, weighing the choice before you. Do you dare to follow the smell and discover what lies beyond, or do you turn back and seek another path?" );
        choice1.setText("Follow the smell");
        choice2.setText("Leave");
        choice3.setText("");
        choice4.setText("");
    }
    public void enterDining(){
        position = "enterDining";
        mainTextArea.setText("As you walk into the dining room, your senses are immediately assaulted by an extravagant sight. A lavish buffet sprawls before you, laden with an abundance of dishes—roasted meats glistening with juices, colorful fruits piled high, and delicate pastries that seem to shimmer in the dim light. The aroma is intoxicating, as if every dish has just been pulled from the oven, wafting toward you in a warm embrace. For a moment, you’re captivated, imagining what it must be like to feast like this on a regular basis, to savor such riches. But as you scan the room, a disquieting thought creeps in: despite the opulence, you see no one.");
        choice1.setText("Indulge");
        choice2.setText("Get out of here");
        choice3.setText("");
        choice4.setText("");
    }

    public void eatFood(){
        position = "eatFood";
        mainTextArea.setText("You dive into the feast, the rich flavors exploding in your mouth as the succulent juices coat your cheeks and lips. Greedily, you shovel food into your mouth, the sounds of smacking and slurping echoing off the walls as you wipe your hands on your clothes, oil and crumbs leaving a mess behind. You devour plate after plate, your stomach stretching and hardening until it feels uncomfortably tight. Leaning back in the grand chair at the head of the table, a wave of satisfaction washes over you, but an insatiable hunger gnaws at your mind, urging you to eat more. Suddenly, a thunderous bang reverberates through the castle, shaking the very walls. Startled,you leap to your feet, but a sharp pain slices through your head, making your vision blur. You grasp the table to steady yourself, but it’s too late. Darkness swirls around you, creeping in like a shadow. You feel your legs buckle, and the ground rushes up to meet you as you collapse, the world fading to black." );
        choice1.setText("Continue?");
        choice2.setText("Give Up");
        choice3.setText("");
        choice4.setText("");
    }

    public void townIntro(){
        position = "townIntro";
        mainTextArea.setText(" As you make your way north from the forest, a charming town comes into view, its gothic architecture towering against the sky. The buildings are adorned with elaborate carvings and pointed arches, creating an almost enchanting atmosphere. Roofs of deep crimson stand out against the gray stone, giving the town a unique character. ");
        choice1.setText("Head into town");
        choice2.setText("Go East");
        choice3.setText("Go South");
        choice4.setText("Go North");
    }

    public void townPostIntro(){
        position = "townPostIntro";
        mainTextArea.setText(" As you make your way north from the forest, the familiar sight of the charming town comes into view. ");
        choice1.setText("Head into town");
        choice2.setText("Go East");
        choice3.setText("Go South");
        choice4.setText("Go North");
    }

    public void townSquare(){
        position = "townSquare";
        mainTextArea.setText(" As you draw closer, the lively sounds of the town square reach your ears—vendors call out their offers, the laughter of children echoes, and the melodic strumming of a lute drifts through the air. The square bustles with energy, filled with townsfolk moving about, engaged in cheerful conversation. There are a couple towns people around that you can talk too.  In the center of the  town square looms a grand church, towering spires stretch toward the sky, while intricate stonework decorates the façade. Dominating the center of the church is a stunning stained glass window featuring a massive blue butterfly, its wings spread wide in a kaleidoscope of colors. The light filtering through creates a dazzling display on the stone floor inside, bathing the area in ethereal hues.");
        choice1.setText("Go Into the Church");
        choice2.setText("Talk to the Townspeople");
        choice3.setText("Leave");
        choice4.setText("");
    }

    public void talkToTownsPeople(){
        position = " talkToTownsPeople";
        mainTextArea.setText("You approach the townspeople, taking in their varied expressions. A man nearby paces nervously, searching his pockets for something, his brow furrowed with worry. Not far from him, a small child shrouded in dirty warn out clothing, with darting, shifty eyes lingers by a bread stall, clearly eyeing a loaf with a longing gaze, glancing around as if waiting for the right moment to grab it. Outside the church, a beggar sits cross-legged, wrapped in a worn cloak, his head bowed, occasionally murmuring to himself.  Who will you speak to first?");
        choice1.setText("Talk to the worried man");
        choice2.setText("Talk to the child");
        choice3.setText("Talk to the beggar");
        choice4.setText("Leave");
    }

    public void worriedMan(){
        position = "worriedMan";
        mainTextArea.setText("You approach the worried man, and he glances at you with a flicker of hope in his eyes, clearly relieved to have someone to talk to. “It’s… my wedding ring,” he mutters, running a hand through his hair anxiously. “I lost it near the lake just outside town. I was skipping stones, and… it slipped right off my finger. I’ve looked all over, but it’s gone.” He sighs heavily, casting a longing glance toward the lake’s direction. “If you could help me find it, I’d be grateful,” he adds, his voice almost pleading. It’s clear this ring means the world to him.");
        choice1.setText("I will help.");
        choice2.setText("And what’s in it for me if I find it?");
        choice3.setText("Leave");
        choice4.setText("");
    }

    public void worriedMan2(){
        position = "worriedMan2";
        mainTextArea.setText(" “I don’t have much,” he admits, “but I can spare some coin if you help me. It’s all I’ve got to offer.” His eyes hold a mix of desperation and hope, clearly willing to part with whatever he can for the ring’s safe return. ");
        choice1.setText("Okay I'll help");
        choice2.setText("Maybe");
        choice3.setText("Leave");
        choice4.setText("");
    }

    public void child(){
        position = "child";
        mainTextArea.setText("You approach the child quietly, watching as his hand inches toward a loaf of bread, his eyes darting around with nervous anticipation. His clothes are tattered, his face smudged with dirt, and there's a desperation in his gaze as he reaches for the bread, clearly torn between fear and hunger. You think you're close enough to stop him before he makes his move.");
        choice1.setText(" Intervene ");
        choice2.setText(" Watch what unfolds ");
        choice3.setText("");
        choice4.setText("");
    }

    public void childStop(){
        position = "childStop";
        mainTextArea.setText(" You reach out and gently place a hand on the child’s shoulder just as he’s about to grab the bread. He startles, his eyes widening as he looks up at you, clearly frightened. ");
        choice1.setText(" You weren't going to steal that bread were you?");
        choice2.setText(" Can I help you? ");
        choice3.setText(" Get out of here, before I catch you again");
        choice4.setText("");
    }

    public void childLetGo(){
        position = "childLetGo";
        mainTextArea.setText(" You let the small boy go, frightened, he runs off and hides. The bread seller offers you a nod of gratitude and a faint smile. “Thank you,” he says. “Times are hard, but we still have to keep order. Here,” he adds, handing you a few coins for your help.  ");
        choice1.setText("Thank the Baker and Leave");
        choice2.setText("Go after the child");
        choice3.setText("Leave");
        choice4.setText("");
    }

    public void childWatch(){
        position = "childWatch";
        mainTextArea.setText(" You hesitate for a moment, deciding to let the child slip the bread into his ragged bag. In an instant, he’s off, disappearing into the crowd with surprising speed. You can almost feel the hunger driving him as he bolts from sight. Unfortunately, the bread seller sees the tail end of the theft, and his face flushes with anger. “Did you just let him go?” he barks, glaring at you. “That little thief’s been taking from my stall all week! If you want to make it right, go after him. Bring him back, and I’ll see to it you’re rewarded for your trouble.” ");
        choice1.setText("Go after the child");
        choice2.setText("Agree and Leave");
        choice3.setText("Leave");
        choice4.setText("");
    }

    public void lookForChild(){
        position = "lookForChild";
        mainTextArea.setText("You follow the winding paths through town, weaving between stalls and crowded streets, until you catch sight of the child huddled in a narrow alley. He’s kneeling beside a young girl, she looks frail, her face pale and eyes heavy, clearly battling an illness. As you step into the alley, they notice you, and both children shrink back, eyes wide with fear. The boy instinctively puts himself between you and the girl, his small form protective, though he’s clearly frightened. They back up against the wall, unsure what you are about to do with them. ");
        choice1.setText("Is there anything I can do to help?");
        choice2.setText("Grab the child and bring him back to the bread seller");
        choice3.setText("Leave");
        choice4.setText("");
    }

    public void childHelp(){
        position = "childHelp";
        mainTextArea.setText(" “My sister,” he whispers, “she’s sick… and I heard about an old herbalist who lived in the cave outside of town. But I can’t go in there—it’s so dark, and… I’m too scared.” He looks up at you, desperation mingling with a flicker of hope. “There’s a beggar by the church with a lantern, but he won’t lend it to me unless I answer all his riddles. I tried, but… I’m just not smart enough to get them right.” He pleads with you, his voice trembling, “Please, will you help me? If I can’t get that medicine, I… I don’t know what will happen to her.” ");
        choice1.setText("Okay I'll go get it, stay here");
        choice2.setText("Who cares? Bring the boy back to the bread seller");
        choice3.setText("Leave");
        choice4.setText("");
    }

    public void childMedicine(){
        position = "childMedicine";
        mainTextArea.setText("The boy’s face lights up with gratitude, his earlier fear fading as he takes a deep breath. “Really? Thank you! The herbalist is in the cave nearby, but it’s dark and scary, I suggest going to get the lantern first!”");
        choice1.setText("Leave");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void bringChildBack(){
        position = "bringChildBack";
        mainTextArea.setText(" You take hold of the boy’s arm firmly, leading him back through the winding streets to the bread seller’s stall. The bread seller’s face twists into a satisfied smirk as he spots you approaching with the boy. “Caught the little thief, did you?” he says, folding his arms across his chest. Alright, here's your reward. You were given 5 coins.");
        choice1.setText("Thank the bread seller and leave");
        choice2.setText("Leave");
        choice3.setText("");
        choice4.setText("");
    }

    public void beggar(){
        position = "beggar";
        mainTextArea.setText(" As you approach the beggar sitting on the stone steps of the church, you notice the worn lines of his face and the glint of a few gold coins in the hat laid out in front of him. His eyes spark with a mix of cunning and wisdom as he regards you.“Ah, a curious soul,” he rasps, his voice gravelly. “Would you care to test your wits against my riddles? Answer them correctly, I may also share some insight that could aid you on your journey.”");
        choice1.setText("Test me");
        choice2.setText("Steal his coins");
        choice3.setText("Leave");
        choice4.setText("");
    }

    public void beggarRiddle1(){
        position = "beggarRiddle1";
        mainTextArea.setText("This thing all things devours; Birds, beasts, trees, flowers; Gnaws iron, bites steel; Grinds hard stones to meal; Slays king, ruins town, And beats mountain down. ");
                choice1.setText("Time");
        choice2.setText("Your mom");
        choice3.setText("Take His Coins");
        choice4.setText("Leave");

    }

    public void beggarRiddle2(){
        position = "beggarRiddle2";
        mainTextArea.setText("The beauty of a cathedral; The agility of the greatest fighters; Like a Phoenix born anew ; My touch may be small but effect is greater than you can imagine.  ");
        choice1.setText("Butterfly");
        choice2.setText("Rocky");
        choice3.setText("Take His Coins");
        choice4.setText("Leave");
    }

    public void beggarRiddle3(){
        position = "beggarRiddle3";
        mainTextArea.setText("It cannot be seen, cannot be felt; Cannot be heard, cannot be smelt; It lies behind stars and under hills; And empty holes it fills; It comes out first and follows after; Ends life, kills laughter.");
        choice1.setText("The Dark");
        choice2.setText("Light Bulb");
        choice3.setText("Take His Coins");
        choice4.setText("Leave");
    }

    public void beggarRiddleIncorrect(){
        position = "beggarRiddleIncorrect";
        mainTextArea.setText(" “Ah, a misstep,” he chuckles, shaking his head. perhaps another attempt would be wise. You may have a second chance… if you dare.”");
        choice1.setText("Try Again");
        choice2.setText("Steal His Coin");
        choice3.setText("Leave");
        choice4.setText("");
    }

    public void beggarRiddleCorrect(){
        position = "beggarRiddleCorrect";
        mainTextArea.setText("So it seems as if you have solved all my riddles he exclaims, reaching beside him to retrieve a beautifully crafted lantern. The metal glints in the light, and the glass panels are adorned with intricate designs. “Take this lantern; it will guide you through the darkness, but be weary, the butterflies are all around, and they will be waiting”");
        choice1.setText("Take the Lantern");
        choice2.setText("Steal His Coin");
        choice3.setText("Leave");
        choice4.setText("");
    }

    public void beggarFinished(){
        position = "beggarFinished";
        mainTextArea.setText("With the lantern securely in your grasp, you feel a sense of purpose surge within you. The beggar’s words linger in your mind as you step away from the church and back into the bustling town square. You could venture towards the cave where the herbalist is said to dwell, or perhaps you’d like to explore the town a bit more. The square is alive with vendors selling various wares, and you might discover something useful or interesting. What will you do next?");
        choice1.setText("Back to town");
        choice2.setText("To the Forrest");
        choice3.setText("To the Cave");
        choice4.setText("To the Castle");
    }

    public void churchCheck(){
        position = "churchCheck";
        mainTextArea.setText(" You approach the grand wooden doors of the church and knock firmly. After a moment, a small square hole opens up in the door, revealing a pair of curious eyes peering out at you. “What purpose do you have here?” the voice calls through the opening, edged with suspicion. ");
        choice1.setText("What is this place?");
        choice2.setText("Any Tips?");
        choice3.setText("Leave");
        choice4.setText("");
    }

    public void churchCheck1(){
        position = "churchCheck1";
        mainTextArea.setText(" The worshipper’s eyes widen slightly as they answer. “This is the Church of Blue. We worship the Wings of Fate, believing that our lives are guided by the delicate flutter of a butterfly’s wings. We serve these wings and do all we can to follow the path that fate has set for us.”");
        choice1.setText(" ");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void churchCheckTips(){
        position = "churchCheckTips";
        mainTextArea.setText("“If you wish to be welcomed inside, show your worth by helping the people of this town. The Wings of Fate reward those who influence the lives around them, even in small ways. Perhaps, once you have made enough of an impact, the doors will open to you.” With that, the small slot closes, and the silence of the towering church returns. You step back, considering the worshipper's words. ");
        choice1.setText("Leave");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void churchChecked(){
        position = "churchChecked";
        mainTextArea.setText("You knock again, waiting in silence until the slot in the door slides open, revealing the same suspicious eyes. The worshipper's gaze is critical, as though he’s about to deny you entry despite your efforts. But just then, a gentle, lilting voice drifts from the other side of the door. “Let them enter,” she says softly, almost a whisper. The voice is compelling, filled with a warmth that seems to melt the hesitation from the worshipper’s face. With a reluctant sigh, he closes the slot and, after a heavy clank of locks, opens the door just enough for you to step through. There, standing in the dim entryway, is a young woman, her face mostly hidden beneath a soft blue cloth. Her eyes are striking—bright and calm, with an air of knowing that stirs something in you.");
        choice1.setText("Talk to the young women");
        choice2.setText("Leave");
        choice3.setText("");
        choice4.setText("");
    }

    public void priestess(){
        position = "priestess";
        mainTextArea.setText("She pauses, her smile flickering beneath the blue cloth that partially conceals her face. I am but a priestess of fate, she replies softly, her tone reverent but with a hint of unease. Her eyes dart to the side for a moment before returning to meet yours.“It is late,” she continues, her voice steadying. “You may rest here tonight, if you wish. The Wings of Fate protect those under this roof.” She gestures toward a quiet hallway leading to a small room with a simple cot and a softly glowing lantern by its side.");
        choice1.setText("Stay the night");
        choice2.setText("Leave");
        choice3.setText("");
        choice4.setText("");
    }

    public void caveIntro(){
        position = "caveIntro";
        mainTextArea.setText("After navigating the twisting, shadowy path, you arrive at its end, where a dark, yawning cave looms before you. The entrance feels like a mouth, ready to swallow you whole. As you peer inside, your eyes strain to make out the jagged walls, barely visible in the dim light. A faint, cool breeze seeps out from the depths, carrying with it an eerie, low whisper. The cave seems to beckon, its darkness hiding whatever secrets lie within. ");
        choice1.setText("Go Inside?");
        choice2.setText("Go East");
        choice3.setText("Go North");
        choice4.setText("Go West");
    }

    public void cavePostIntro(){
        position = "cavePostIntro";
        mainTextArea.setText("You find yourself standing before the cave once more, its dark, imposing entrance as unnerving as ever. Whatever secrets it holds, they haven't changed... but perhaps, this time, you have. Will you venture deeper?");
        choice1.setText("Go Inside?");
        choice2.setText("Go East");
        choice3.setText("Go North");
        choice4.setText("Go West");
    }

    public void insideOfCave(){
        position = "insideOfCave";
        mainTextArea.setText("Steeling yourself, you step into the cave, leaving the faint light of the forest behind. The air grows colder, and the faint sounds of the outside world fade, replaced by the echo of your footsteps. The walls, slick with moisture, close in around you, narrowing as you press forward. Something is waiting in the depths. Grab the Medicine (Will do Maze Later)");
        choice1.setText("Grab Medicine");
        choice2.setText("Grab Book of Knowledge");
        choice3.setText("Leave");
        choice4.setText("");
    }

    public void getMedicine(){
        position = "getMedicine";
        mainTextArea.setText("You take the Medicine");
        choice1.setText("Leave");
        choice2.setText(" ");
        choice3.setText("");
        choice4.setText("");
    }

    public void bookOfKnowledge(){
        position = "bookOfKnowledge";
        mainTextArea.setText("You take the book");
        choice1.setText("Leave");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void lakeIntro(){
        position = "lakeIntro";
        mainTextArea.setText("You head down the path leading toward the lake, and as you draw closer, its waters come into view, shimmering like a thousand sapphires beneath the morning light. Gentle waves lap at the shore, sending flickers of sunlight dancing across the surface. The scene is almost hypnotic, the lake stretching out with a serene beauty that feels both calming and mysterious.");
        choice1.setText("Continue to the Lake");
        choice2.setText("Go North");
        choice3.setText("Go West");
        choice4.setText("Go South");
    }

    public void continueToLake(){
        position = "continueToLake";
        mainTextArea.setText("You continue down to the lake, where the water glistens in the soft light, each ripple casting a thousand sapphire-like sparks across its surface. At the water’s edge, a stone rests, half-buried in the shore, its surface rough and uneven from age. It catches your attention, though the markings on it are too worn to make out from here. Across the lake, a solitary figure sits on a narrow dock that stretches over the water. The fisherman, with his rod cast into the lake, seems lost in the tranquility of the moment, his silhouette calm and still against the vastness of the shimmering water. The lake stretches quietly between you, inviting but mysterious, as if guarding secrets just beneath its surface.");
        choice1.setText("Read the Stone");
        choice2.setText("Talk to the Fisherman");
        choice3.setText("Leave");
        choice4.setText("");
    }

    public void readStone(){
        position = "readStone";
        mainTextArea.setText("You approach the weathered stone, crouching down to get a closer look at the faint inscription. The letters are old and faded, but as your eyes trace the worn grooves, the message becomes clear: “To bring balance to this land, a truth must be burned. Knowledge surrendered in flame shall awaken peace.”");
        choice1.setText(" ");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void burnKnowledge(){
        position = "burnKnowledge";
        mainTextArea.setText("You approach the stone, the ancient Book of Knowledge in one hand and an oil lantern in the other. The air feels charged as you place the book upon the stone, and with a steady breath, you ignite it. Flames lick across the pages, and as they consume the text, a powerful ripple spreads through the air, reaching out over the lake.Suddenly, a brilliant white light erupts from the lake’s center, piercing through the mist that has gathered above the water. From the light, a magnificent silver broadsword rises, its blade gleaming and perfectly polished. Around it, delicate blue butterflies flutter and spiral upward, dispersing into the sky in a mesmerizing dance.The sword hovers just in front of you, steady and waiting. Its aura is both beautiful and intimidating, as if carrying a history and power beyond comprehension.Will you reach out and take it?");
        choice1.setText("Take the Sword");
        choice2.setText("Leave the Sword");
        choice3.setText("");
        choice4.setText("");
    }

    public void takeSword(){
        position = "takeSword";
        mainTextArea.setText("You reach out, fingers closing around the hilt of the silver broadsword. The instant your hand touches it, a surge of energy courses through you—a blend of strength, clarity, and an unwavering sense of purpose. The weight of the blade feels natural, as though it was meant for you, and with it comes a profound realization.Images and feelings flood your mind, revealing your fate. You understand now that this sword carries more than mere power; it holds the weight of responsibility and justice. This town, with all its struggles and flaws, needs a protector—someone to ensure that wrongs are righted, that peace prevails, that darkness has no place within its walls.It is your destiny to bring balance, to wield this blade in service of the people, transforming the town into a sanctuary where no harm or injustice will ever take root again.");
        choice1.setText("Become Justice");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void leaveSword(){
        position = "leaveSword";
        mainTextArea.setText("You hesitate, your hand hovering above the hilt of the shimmering silver broadsword. The sense of responsibility and purpose washes over you, but something deeper compels you to reconsider. This weapon, powerful and magnificent, is not yours to claim.You step back from the blade, letting the light envelop it once more. The butterflies continue to dance around it, and as you turn away, you feel a strange but comforting certainty settling in your chest.");
        choice1.setText("Leave");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void swordActivated(){
        position = "swordActivated";
        mainTextArea.setText("You continue down to the lake, where the water glistens in the soft light, each ripple casting a thousand sapphire-like sparks across its surface. At the water’s edge, the sword still hovers, it's reflection shimmering in the water in front of it..");
        choice1.setText("Read the Stone");
        choice2.setText("Talk to the Fisherman");
        choice3.setText("Take the Sword");
        choice4.setText("Leave");
    }

    public void fisherman(){
        position = "fisherman";
        mainTextArea.setText("You make your way around the lake toward the dock where the fisherman sits, his back slightly hunched as he peers intently at the water. The closer you get, the clearer it becomes that he’s deeply absorbed in his task, Still, you step onto the dock, the wood creaking softly underfoot. The fisherman doesn’t look up but shifts slightly, as if sensing your presence and reluctant to acknowledge it. His face is weathered, eyes fixed on the water, and the lines of his mouth hint at someone who’d rather be left alone.");
        choice1.setText("Greet the Fisherman");
        choice2.setText("Leave");
        choice3.setText("");
        choice4.setText("");
    }

    public void fishermanGreet(){
        position = "fishermanGreet";
        mainTextArea.setText("The fisherman grumbles in response, his words muffled and barely audible, like he’s speaking more to the lake than to you. He shifts his line slightly, eyes never leaving the water. For a moment, it seems he might just ignore you entirely. But then, without turning his head, he mutters, “If you’re here for answers, you’re looking in the wrong place.”");
        choice1.setText("Apologize and Leave");
        choice2.setText("Didn't come here to waste my time fishing for answers from some old dock drifter");
        choice3.setText("");
        choice4.setText("");
    }

    public void fishermanGreet1(){
        position = "fishermanGreet1";
        mainTextArea.setText("The fisherman stands up abruptly, fists clenched, clearly ready to defend his pride. He's much bigger than you. You're odds don't look good.");
        choice1.setText("Get out of there");
        choice2.setText("Don't back down");
        choice3.setText("");
        choice4.setText("");
    }

    public void fishermanLaugh(){
        position = "fishermanLaugh";
        mainTextArea.setText("After a tense moment, a smirk pulls at the corner of his mouth, and he suddenly breaks into a gruff laugh. “Alright, alright,” he chuckles, his shoulders relaxing as he reaches into his pocket. “I like someone with a bit of fire. Here.” He holds out a small, tarnished ring, its band twisted like roots. “Caught it this morning, and it’s been nothing but a nuisance, kinda like you. Take it—and get out of my sight.” With a dismissive wave, he turns back to his fishing, leaving you with the ring glinting in your hand.");
        choice1.setText("Leave");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void wealthStart(){
        position = "wealthStart";
        mainTextArea.setText("WEALTH ROUTE");
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void justiceStart(){
        position = "justiceStart";
        mainTextArea.setText("JUSTICE ROUTE");
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void loveStart(){
        position = "loveStart";
        mainTextArea.setText("LOVE ROUTE");
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public void knowledgeStart(){
        position = "knowledgeStart";
        mainTextArea.setText("KNOWLEDGE ROUTE");
        choice1.setText(">");
        choice2.setText("");
        choice3.setText("");
        choice4.setText("");
    }

    public class TitleScreenHandler implements ActionListener {

        public void actionPerformed(ActionEvent event){

            createGameScreen();
        }
    }

    public class ChoiceHandler implements ActionListener{

        public void actionPerformed(ActionEvent event){

            String yourChoice = event.getActionCommand();

            switch(position) {
                case "forrestIntro":
                    switch (yourChoice) {
                        case "c1":
                            castleIntro();
                            break;
                        case "c2":
                            lakeIntro();
                            break;
                        case "c3":
                            caveIntro();
                            break;
                        case "c4":
                            townIntro();
                            break;
                    }
                    break;
                case "castleIntro":
                    switch (yourChoice) {
                        case "c1":
                            talkToGuard();
                            break;
                        case "c2":
                            lakeIntro();
                            break;
                        case "c3":
                            caveIntro();
                            break;
                        case "c4":
                            townIntro();
                            break;
                    }
                    break;
                case "talkToGuard":
                    switch (yourChoice) {
                        case "c1": talkToGuard2();break;
                        case "c2": talkToGuard3();break;
                        case "c3": castlePostIntro(); break;
                        case "c4":
                            if (varBeggar == 1) {
                                talkToGuardTriggered();
                            } else {
                                castlePostIntro();
                            }
                            break;
                    }
                    break;
                case "talktoGuard2":
                    switch (yourChoice) {
                        case "c1":
                            talkToGuard4();
                            break;
                        case "c2":
                            bribeGuard();
                            break;
                        case "c3":
                            castlePostIntro();
                            break;
                    }
                    break;
            }
        }
    }
}