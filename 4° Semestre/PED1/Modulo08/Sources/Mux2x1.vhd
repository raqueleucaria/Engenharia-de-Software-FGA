library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity Mux2x1 is
    Port ( a : in STD_LOGIC_VECTOR (3 downto 0);
           b : in STD_LOGIC_VECTOR (3 downto 0);
           sel : in STD_LOGIC;
           s : out STD_LOGIC_VECTOR (3 downto 0));
end Mux2x1;

architecture Behavioral of Mux2x1 is

begin

    s <= a when sel='0' else
         b when sel='1';

end Behavioral;
