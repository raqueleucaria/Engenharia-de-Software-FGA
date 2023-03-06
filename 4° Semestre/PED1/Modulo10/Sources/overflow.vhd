library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity overflow is
    Port ( a : in STD_LOGIC;
           b : in STD_LOGIC;
           s : out STD_LOGIC);
end overflow;

architecture Behavioral of overflow is

begin

 s <= a xnor b;

end Behavioral;
