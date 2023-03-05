library IEEE;
use IEEE.STD_LOGIC_1164.ALL;

entity main is
    Port ( a : in STD_LOGIC_VECTOR (3 downto 0); --entrada numero a
           b : in STD_LOGIC_VECTOR (3 downto 0); --entrada numero b
           sel : in STD_LOGIC; --seleção do display
           e : out STD_LOGIC_VECTOR (3 downto 0); --enable. Para habilitar o display, mandar e(n)<=1;
           S : out STD_LOGIC_VECTOR (6 downto 0)); --(sinal multiplexado para saída)
end main;

architecture Behavioral of main is

    signal conector1 : std_logic_vector (3 downto 0);
    
    component Mux2x1
        Port ( a : in STD_LOGIC_VECTOR (3 downto 0);
               b : in STD_LOGIC_VECTOR (3 downto 0);
               sel : in STD_LOGIC;
               s : out STD_LOGIC_VECTOR (3 downto 0));
    end component;
    
    component BCD_7SEG
        Port ( bcdIn : in STD_LOGIC_VECTOR (3 downto 0);
               S : out STD_LOGIC_VECTOR (6 downto 0));
    end component;

begin

    e(0) <= '0' when sel='0' else
            '1' when sel='1';
    e(1) <= '0' when sel='1' else
            '1' when sel='0';
    e(2) <= '1' when sel='0' else
            '1' when sel='1';
    e(3) <= '1' when sel='1' else
            '1' when sel='0';        
    
    mux : Mux2x1 port map(a => a, b => b, sel => sel, s => conector1);
    bcd : BCD_7SEG port map(bcdIn => conector1, S => S);       

end Behavioral;
