library IEEE;
use IEEE.STD_LOGIC_1164.ALL;
use IEEE.STD_LOGIC_UNSIGNED.ALL;


entity sumSub is
    Port ( busx : in STD_LOGIC_VECTOR (3 downto 0);
           busy : in STD_LOGIC_VECTOR (3 downto 0);
           op : in STD_LOGIC;
           busS : out STD_LOGIC_VECTOR (3 downto 0);
           overflow : out STD_LOGIC);
end sumSub;

architecture Behavioral of sumSub is

    signal s_Y, s_S: STD_LOGIC_VECTOR (3 downto 0);
    
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
    soma4b: somador4bits port map (busX => busX, busY => s_Y, cin => op, busS => s_S, ovf => overflow);
    
process (op, s_S)
begin
  if (op='1' and s_S(3)='1') then
    busS(3) <= '1';
    busS(2 downto 0) <= not(s_S(2 downto 0)) + "001";
  else
    busS <= s_S;
  end if;
end process;

end Behavioral;
