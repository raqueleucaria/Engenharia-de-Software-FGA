library IEEE;
use IEEE.STD_LOGIC_1164.ALL;


entity BCD_7SEG is
    Port ( bcdIn : in STD_LOGIC_VECTOR (3 downto 0);
           S : out STD_LOGIC_VECTOR (6 downto 0));
end BCD_7SEG;

architecture Behavioral of BCD_7SEG is

begin

    S <= "0000001" when bcdIn="0000" else
         "1001111" when bcdIn="0001" else
         "0010010" when bcdIn="0010" else
         "0000110" when bcdIn="0011" else
         "1001100" when bcdIn="0100" else
         "0100100" when bcdIn="0101" else
         "0100000" when bcdIn="0110" else
         "0001111" when bcdIn="0111" else
         "0000000" when bcdIn="1000" else
         "0000100" when bcdIn="1001";
         
end Behavioral;
