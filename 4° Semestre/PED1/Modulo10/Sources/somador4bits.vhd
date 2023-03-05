library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity somador4bits is
    Port ( busx : in STD_LOGIC_VECTOR (3 downto 0);
           busy : in STD_LOGIC_VECTOR (3 downto 0);
           cin : in STD_LOGIC;
           busS : out STD_LOGIC_VECTOR (3 downto 0);
           ovf: out STD_LOGIC);
end somador4bits;

architecture Behavioral of somador4bits is

    signal c0, c1, c2, c3 : STD_LOGIC;

    component somador 
        Port ( x : in STD_LOGIC;
               y : in STD_LOGIC;
               s : out STD_LOGIC;
               cin : in STD_LOGIC;
               cout : out STD_LOGIC);
    end component;
    
    component overflow
        Port ( a : in STD_LOGIC;
               b : in STD_LOGIC;
               s : out STD_LOGIC);
    end component;
    
begin
    
    
    sum1: somador port map (x=>busX(0), y=>busY(0), s=>busS(0), cin=>cin, cout=>c0);
    sum2: somador port map (x=>busX(1), y=>busY(1), s=>busS(1), cin=>c0, cout=>c1);
    sum3: somador port map (x=>busX(2), y=>busY(2), s=>busS(2), cin=>c1, cout=>c2);
    sum4: somador port map (x=>busX(3), y=>busY(3), s=>busS(3), cin=>c2, cout=>c3);
    
    over: overflow port map (a => c2, b => c3, s => ovf);

end Behavioral;
