library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity somador is
    Port ( x : in STD_LOGIC;
           y : in STD_LOGIC;
           s : out STD_LOGIC;
           cin : in STD_LOGIC;
           cout : out STD_LOGIC);
end somador;

architecture Behavioral of somador is

begin

    s <= x xor y xor cin;
    cout <= (x and y) or (x and cin) or (y and cin);

end Behavioral;
