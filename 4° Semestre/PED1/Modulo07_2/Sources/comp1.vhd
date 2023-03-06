library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity comp1 is
    Port ( x : in STD_LOGIC_VECTOR (3 downto 0);
           sel : in STD_LOGIC;
           s : out STD_LOGIC_VECTOR (3 downto 0)
          );
end comp1;

architecture Behavioral of comp1 is

begin

    s(0) <= (x(0) xor sel);
    s(1) <= (x(1) xor sel);
    s(2) <= (x(2) xor sel);
    s(3) <= (x(3) xor sel);

end Behavioral;
