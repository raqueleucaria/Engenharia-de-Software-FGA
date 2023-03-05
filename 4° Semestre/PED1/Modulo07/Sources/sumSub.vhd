library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity sumSub is
    Port ( busx : in STD_LOGIC_VECTOR (3 downto 0);
           busy : in STD_LOGIC_VECTOR (3 downto 0);
           op : in STD_LOGIC;
           busS : out STD_LOGIC_VECTOR (3 downto 0);
           overflow : out STD_LOGIC);
end sumSub;

architecture Behavioral of sumSub is

    signal s_Y: STD_LOGIC_VECTOR (3 downto 0);
    
    component somador4bits
        Port ( busx : in STD_LOGIC_VECTOR (3 downto 0);
               busy : in STD_LOGIC_VECTOR (3 downto 0);
               cin : in STD_LOGIC;
               busS : out STD_LOGIC_VECTOR (3 downto 0);
               ovf: out STD_LOGIC);
    end component;

    component comp1 
        Port ( x : in STD_LOGIC_VECTOR (3 downto 0);
               sel : in STD_LOGIC;
               s : out STD_LOGIC_VECTOR (3 downto 0));
    end component;

begin

    complemento: comp1 port map (x => busy, sel => op, s => s_Y);
    soma4b: somador4bits port map (busX => busX, busY => s_Y, cin => op, busS => busS, ovf => overflow);

end Behavioral;
